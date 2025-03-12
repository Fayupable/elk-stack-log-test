package com.fayupable.elkstack.request;


import lombok.Data;

import java.util.List;

@Data
public class AddUserInfoRequest {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;


}
