package com.fayupable.elkstack.mapper;

import com.fayupable.elkstack.dto.UserInfoDto;
import com.fayupable.elkstack.entity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoMapper {

    public UserInfoDto fromUserInfo(UserInfo userInfo) {
        if (userInfo == null) return null;

        UserInfoDto dto = new UserInfoDto();
        dto.setUserId(userInfo.getUserId());
        dto.setUsername(userInfo.getUsername());
        dto.setEmail(userInfo.getEmail());
        dto.setFirstName(userInfo.getFirstName());
        dto.setLastName(userInfo.getLastName());
        dto.setRoles(userInfo.getRoles());
        dto.setCreatedAt(userInfo.getCreatedAt());
        dto.setUpdatedAt(userInfo.getUpdatedAt());

        return dto;
    }
}
