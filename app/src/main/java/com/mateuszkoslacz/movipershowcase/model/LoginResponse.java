package com.mateuszkoslacz.movipershowcase.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("data")
    @Expose
    private LoginData data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userCredits")
    @Expose
    private Integer userCredits;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Integer getUserCredits() {
        return userCredits;
    }

    public void setUserCredits(Integer userCredits) {
        this.userCredits = userCredits;
    }
}
