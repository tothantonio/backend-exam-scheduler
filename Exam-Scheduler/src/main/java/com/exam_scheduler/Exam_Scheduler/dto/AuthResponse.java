package com.exam_scheduler.Exam_Scheduler.dto;

public class AuthResponse {
    private final String token;

    public AuthResponse(String token){
        this.token = token;
    }

    public String getToken(){return this.token;}
}
