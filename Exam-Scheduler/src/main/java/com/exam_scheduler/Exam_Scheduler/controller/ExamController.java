package com.exam_scheduler.Exam_Scheduler.controller;

import com.exam_scheduler.Exam_Scheduler.dto.ExamRequest;
import com.exam_scheduler.Exam_Scheduler.dto.ExamResponse;
import com.exam_scheduler.Exam_Scheduler.model.Exam;
import com.exam_scheduler.Exam_Scheduler.service.ExamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public List<ExamResponse> getExams(Authentication auth) {
        return examService.getExam(auth.getName());
    }

    @PostMapping
    public ExamResponse addExam(@RequestBody @Valid ExamRequest dto, Authentication authentication){
        return examService.addExam(authentication.getName(), dto);
    }

    @PutMapping("/{id}")
    public ExamResponse updateExam(@PathVariable Long id, @RequestBody @Valid ExamRequest dto, Authentication authentication){
        return examService.updateExam(id, authentication.getName(), dto);
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id, Authentication authentication){
        examService.deleteExam(id, authentication.getName());
    }

}
