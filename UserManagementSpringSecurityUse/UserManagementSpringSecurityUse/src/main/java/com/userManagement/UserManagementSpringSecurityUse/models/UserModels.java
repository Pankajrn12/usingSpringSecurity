package com.userManagement.UserManagementSpringSecurityUse.models;

import lombok.Data;

@Data
public class UserModels {
    private Long id;
    private String fullName;
    private String email;
    private String address;
    private String qualification;
    private String password;
    private  String role;

}
