package com.user.Model;

import java.io.Serializable;

public  class Autherity implements Serializable {

    private static final long serialVersionUID = 1464462L;


    private String role;



    public Autherity(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }

    public void setAuthority(String role) {
        this.role = role;
    }
    }

