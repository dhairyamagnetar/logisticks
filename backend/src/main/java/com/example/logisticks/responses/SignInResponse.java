package com.example.logisticks.responses;

public class SignInResponse {
    private int key;
    private boolean login;
    public SignInResponse(int key, boolean login) {
        this.key = key;
        this.login = login;
    }
    public SignInResponse(){}

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
