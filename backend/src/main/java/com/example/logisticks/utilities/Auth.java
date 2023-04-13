package com.example.logisticks.utilities;

import com.example.logisticks.models.User;

public class Auth {
    private static User loggedInUser;
    public static User getLoggedInUser() {
        return loggedInUser;
    }
    public static void setLoggedInUser(User loggedInUser) {
        Auth.loggedInUser = loggedInUser;
    }
}
