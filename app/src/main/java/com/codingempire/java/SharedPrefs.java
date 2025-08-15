package com.codingempire.java;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPrefs {

    private static final String PREF_NAME = "MyPrefrences";
    private static final String KEY_USER = "User_data";
    private static final String IS_LOGGED_IN = "isLoggedIn";

    SharedPreferences prefs ;
    Gson gson ;
    SharedPreferences.Editor edit;

    public SharedPrefs(Context context){
        prefs= context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
        gson = new Gson();
    }
    public void saveUser(UserModel user){
        SharedPreferences.Editor edit = prefs.edit();
        String json = gson.toJson(user);
        edit.putString(KEY_USER,json);
        edit.apply();
    }
    public  UserModel getUser(){
        String json = prefs.getString(KEY_USER,null);
        if(json != null){
            return gson.fromJson(json , UserModel.class);
        }
        return  null;
    }
    public void setIsLoggedIn(boolean loggedIn){
        edit.putBoolean(IS_LOGGED_IN, loggedIn);
        edit.apply();
    }
    public boolean isLoggedIn() {
        return prefs.getBoolean(IS_LOGGED_IN, false);
    }








}
