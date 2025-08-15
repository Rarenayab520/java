package com.codingempire.java;

public class UserModel {
    String username, password, email;

    public UserModel() {
    }

    public UserModel(String userName, String email, String password) {
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



/*
 *
 * class ... {
 *  int Name, Class;
 *
 * public:
 *   ABC (){}
 *   ABC (int name, int class) {
 * Name = name;
 * Class = class;
 * }
 *
 *   func (int Name, int Class) {
 *
 *       cin >> "Eneter your name ?" >> Name;
 *       cin >> "Enter your class ?" >> Class;
 *
 * }
 *
 * }
 * };
 *
 * int main () {
 *
 * ABC abc;
 *
 * abc.func();
 *
 * }
 *
 *
 * */