package com.znz.tpip_backend.model;

import lombok.Data;

@Data
public class User {
    protected Long id;
    protected String name;
    protected String email;
    protected String password;
    protected String role;
}
