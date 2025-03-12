package com.fayupable.elkstack.service;

import com.fayupable.elkstack.dto.UserInfoDto;
import com.fayupable.elkstack.entity.UserInfo;
import com.fayupable.elkstack.enums.Role;
import com.fayupable.elkstack.exception.EmailAlreadyExistsException;
import com.fayupable.elkstack.exception.UsernameAlreadyExistsException;
import com.fayupable.elkstack.mapper.UserInfoMapper;
import com.fayupable.elkstack.repository.IUserRepository;
import com.fayupable.elkstack.request.AddUserInfoRequest;
import com.fayupable.elkstack.request.LoginRequest;
import com.fayupable.elkstack.request.UpdateUserRoleRequest;
import com.fayupable.elkstack.response.JwtResponse;
import com.fayupable.elkstack.response.LoginResponse;
import com.fayupable.elkstack.security.jwt.JwtUtils;
import com.fayupable.elkstack.security.user.AuthDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {


    private final IUserRepository userRepository;
    private final UserInfoMapper userInfoMapper;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public UserInfoDto addUser(AddUserInfoRequest request) {
        log.info("Registering new user with username: {}", request.getUsername());
        validateUserCredentials(request.getUsername(), request.getEmail());

        UserInfoDto userDto = Optional.of(request)
                .map(this::createUserHelper)
                .map(userRepository::save)
                .map(userInfoMapper::fromUserInfo)
                .orElseThrow(() -> new RuntimeException("User not created!"));

        log.info("User registered successfully. User ID: {}", userDto.getUserId());
        return userDto;
    }


    private UserInfo createUserHelper(AddUserInfoRequest request) {
        UserInfo user = new UserInfo();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Collections.singleton(Role.ROLE_ADMIN));
        return user;
    }

    private void validateUserCredentials(String username, String email) {
        if (userRepository.existsByUsername(username)) {
            throw new UsernameAlreadyExistsException("Username is already taken: " + username);
        }
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Email is already registered: " + email);
        }
    }


    @Override
    public LoginResponse login(LoginRequest request) {
        log.info("Logging in user with email: {}", request.getEmail());
        Authentication authentication = authenticateUser(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = generateJwt(authentication);
        UserInfo user = getUserByEmail(request.getEmail());
        log.info("User logged in successfully. User ID: {}", user.getUserId());
        return new LoginResponse("Login success", new JwtResponse(user.getUserId(), jwt));

    }

    private Authentication authenticateUser(LoginRequest request) {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    }

    private String generateJwt(Authentication authentication) {
        return jwtUtils.generateTokenForUser(authentication);
    }

    private UserInfo getUserByEmail(String email) {
        Optional<UserInfo> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return user.get();
    }

    @Override
    public LoginResponse logout(String authorizationHeader) {
        log.info("Processing logout request");
        String token = extractToken(authorizationHeader);
        processLogout(token);
        return createLogoutResponse();
    }

    private String extractToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            log.warn("Invalid authorization header");
            throw new IllegalArgumentException("No token provided");
        }
        return authorizationHeader.substring(7);
    }

    private void processLogout(String token) {
        try {
            invalidateToken(token);
            clearSecurityContext();
            log.info("User logged out successfully");
        } catch (Exception e) {
            log.error("Logout failed", e);
            throw new RuntimeException("Logout failed: " + e.getMessage());
        }
    }

    private void invalidateToken(String token) {
        jwtUtils.blacklistToken(token);
    }

    private void clearSecurityContext() {
        SecurityContextHolder.clearContext();
    }

    private LoginResponse createLogoutResponse() {
        return new LoginResponse("Logout successful", null);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    @Override
    public UserInfoDto updateUserRole(UpdateUserRoleRequest request, UUID userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UUID adminId = ((AuthDetails) principal).getId();

        log.info("Admin ID: {} is updating role for user ID: {} to role: {}", adminId, userId, request.getRole());
        log.info("Updating role for user ID: {} to role: {}", userId, request.getRole());
        UserInfo user = findUserById(userId);
        UserInfo updatedUser = updateUserRoles(user, request.getRole());
        return convertToDto(updatedUser);
    }

    private UserInfo findUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User not found with ID: {}", userId);
                    return new IllegalArgumentException("User not found");
                });
    }

    private UserInfo updateUserRoles(UserInfo user, Role newRole) {
        Set<Role> roles = new HashSet<>();
        roles.add(newRole);
        user.setRoles(roles);
        UserInfo updatedUser = userRepository.save(user);
        log.info("Role updated successfully for user ID: {}", user.getUserId());
        return updatedUser;
    }

    private UserInfoDto convertToDto(UserInfo userInfo) {
        return userInfoMapper.fromUserInfo(userInfo);
    }


    @Override
    public Map<String, Object> validateToken(String token) {
        log.info("Validating token...");
        Map<String, Object> response = new HashMap<>();
        try {
            boolean isValid = jwtUtils.validateToken(token);
            if (isValid) {
                response.put("valid", true);
                response.put("username", jwtUtils.getUserNameFromToken(token));
                response.put("userId", jwtUtils.getUserIdFromToken(token));
            } else {
                response.put("valid", false);
                response.put("message", "Invalid token");
            }
        } catch (Exception e) {
            response.put("valid", false);
            response.put("message", "Error validating token: " + e.getMessage());
        }
        return response;
    }

}
