package com.fayupable.elkstack.service;

import com.fayupable.elkstack.dto.UserInfoDto;
import com.fayupable.elkstack.request.AddUserInfoRequest;
import com.fayupable.elkstack.request.LoginRequest;
import com.fayupable.elkstack.request.UpdateUserRoleRequest;
import com.fayupable.elkstack.response.LoginResponse;
import jakarta.transaction.Transactional;

import java.util.Map;
import java.util.UUID;

public interface IUserService {
    UserInfoDto addUser(AddUserInfoRequest request);

    LoginResponse login(LoginRequest request);

    LoginResponse logout(String authorizationHeader);

    UserInfoDto updateUserRole(UpdateUserRoleRequest request, UUID userId);

    Map<String, Object> validateToken(String token);
}
