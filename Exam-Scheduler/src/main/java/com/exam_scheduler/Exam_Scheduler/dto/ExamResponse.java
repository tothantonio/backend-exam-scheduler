package com.exam_scheduler.Exam_Scheduler.dto;

import java.time.LocalDate;

public class ExamResponse {
    private Long id;
    private String subject;
    private LocalDate localDate;
    private String userEmail;

    public ExamResponse(Long id, String subject, LocalDate localDate, String userEmail) {
        this.id = id;
        this.subject = subject;
        this.localDate = localDate;
        this.userEmail = userEmail;
    }

    public Long getId() {
        return id;
    }
    public String getSubject() {
        return subject;
    }
    public LocalDate getLocalDate() {return localDate;}
    public String getUserEmail() {
        return userEmail;
    }
}
