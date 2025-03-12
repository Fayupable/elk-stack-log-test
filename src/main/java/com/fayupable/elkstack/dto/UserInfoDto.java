package com.fayupable.elkstack.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fayupable.elkstack.enums.Role;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
public class UserInfoDto {
    private UUID userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Set<Role> roles;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

}
