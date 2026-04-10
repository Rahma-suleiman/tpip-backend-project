package com.znz.tpip_backend.dto;

import lombok.Data;

@Data
public class UserDto {
    protected Long id;
    protected String name;
    protected String email;
    protected String password;
    protected String role;
}
