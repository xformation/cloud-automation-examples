package com.user.Model;

import java.util.List;

public class UserClass {
    public static enum Types {
        CUSTOMER,
        USER,
        SUPER;
    }
    private String id;
    private Types type;

    private String username;

    private String password;

    private boolean active = true;

    private String email;

    private List<Autherity> roles;

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Autherity> getRoles() {
        return roles;
    }

    public void setRoles(List<Autherity> roles) {
        this.roles = roles;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
