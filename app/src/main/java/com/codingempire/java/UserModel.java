package com.codingempire.java;

public class UserModel {
        String username , password,email;

    public UserModel(String password, String userName, String email) {
        this.username = userName;
        this.email = email;
        this.password = password;
    }

        public String getUsername() {
        return username;
        }
        public String getEmail() {
        return email;
        }
        public String getPassword() {
        return password;
        }
    }


