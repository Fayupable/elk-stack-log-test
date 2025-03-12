package com.fayupable.elkstack.request;

import com.fayupable.elkstack.enums.Role;
import lombok.Data;

@Data
public class UpdateUserRoleRequest {
    private Role role;
}
