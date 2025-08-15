package com.codingempire.java;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SharedPrefs {

    private static final String PREF_NAME = "MyPreferences";
    private static final String KEY_USER = "user_data";
    private static final String IS_LOGGED_IN = "isLoggedIn";

    private final SharedPreferences prefs;
    private final Gson gson;

    public SharedPrefs(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveUser(UserModel user) {
        String json = gson.toJson(user);
        prefs.edit().putString(KEY_USER, json).apply();
    }

    public UserModel getUser() {
        String json = prefs.getString(KEY_USER, null);
//        if (json != null) {
//            return gson.fromJson(json, UserModel.class);
//        }
//        return null;

        return json != null ? gson.fromJson(json, UserModel.class) : null; // non-nullable - nullpointyerexception
    }

    public void setIsLoggedIn(boolean loggedIn) {
        prefs.edit().putBoolean(IS_LOGGED_IN, loggedIn).apply();
    }

    public boolean isLoggedIn() {
        return prefs.getBoolean(IS_LOGGED_IN, false);
    }

    public void clear() {
        prefs.edit().clear().apply();
    }
}
