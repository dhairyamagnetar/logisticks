package com.example.logisticks.utilities;

import com.example.logisticks.models.User;

public class Auth {
    private static int key;
    public static int getKey() {
        return key;
    }
    public static void setKey(int key) {
        Auth.key = key;
    }
}
