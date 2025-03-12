package com.fayupable.elkstack.controller;

import com.fayupable.elkstack.request.AddUserInfoRequest;
import com.fayupable.elkstack.request.LoginRequest;
import com.fayupable.elkstack.request.UpdateUserRoleRequest;
import com.fayupable.elkstack.response.ElkStackResponse;
import com.fayupable.elkstack.response.LoginResponse;
import com.fayupable.elkstack.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user/auth")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<ElkStackResponse> register(@RequestBody AddUserInfoRequest request) {
        return ResponseEntity.ok(new ElkStackResponse("User registered", userService.addUser(request)));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        return ResponseEntity.ok(userService.validateToken(token));
    }

    @PostMapping("/logout")
    public ResponseEntity<ElkStackResponse> logout(@RequestHeader("Authorization") String authHeader) {
        return ResponseEntity.ok(new ElkStackResponse("User logged out", userService.logout(authHeader)));
    }

    @PutMapping("/updateRole/{userId}")
    public ResponseEntity<ElkStackResponse> updateRole(@RequestBody UpdateUserRoleRequest request,@PathVariable UUID userId) {
        return ResponseEntity.ok(new ElkStackResponse("User role updated", userService.updateUserRole(request, userId)));
    }
}
