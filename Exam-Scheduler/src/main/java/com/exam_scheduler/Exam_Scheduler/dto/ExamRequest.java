package com.exam_scheduler.Exam_Scheduler.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExamRequest {

    @NotBlank(message = "Subject is required")
    private String subject;

    @NotNull(message = "Date is required")
    @Future(message = "Date must be in the future")
    private LocalDate localDate;

    public ExamRequest(String subject, LocalDate now) {
        this.subject = subject;
        this.localDate = now;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
