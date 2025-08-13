package com.exam_scheduler.Exam_Scheduler.service;

import com.exam_scheduler.Exam_Scheduler.dto.ExamRequest;
import com.exam_scheduler.Exam_Scheduler.dto.ExamResponse;
import com.exam_scheduler.Exam_Scheduler.model.Exam;
import com.exam_scheduler.Exam_Scheduler.model.User;
import com.exam_scheduler.Exam_Scheduler.repository.ExamRepository;
import com.exam_scheduler.Exam_Scheduler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private UserRepository userRepository;

    //CRUD operations(create, read, update, delete)

    public ExamResponse addExam(String email, ExamRequest dto){
        User user = userRepository.findByEmail(email).orElseThrow();
        Exam exam = new Exam(dto.getSubject(), dto.getLocalDate(), user);
        Exam saved = examRepository.save(exam);
        return mapToResponse(saved);
    }

    public List<ExamResponse> getExam(String email){
        return examRepository.findByUserEmail(email).stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ExamResponse updateExam(Long id, String email, ExamRequest dto){
        Exam exam = examRepository.findById(id).orElseThrow();

        if(!exam.getUser().getEmail().equals(email)){
            throw new RuntimeException("You do not have permission to update this exam.");
        }

        exam.setSubject(dto.getSubject());
        exam.setLocalDate(dto.getLocalDate());
        Exam updatedExam = examRepository.save(exam);
        return mapToResponse(updatedExam);
    }

    public void deleteExam(Long id, String email){
        Exam exam = examRepository.findById(id).orElseThrow();
        if(!exam.getUser().getEmail().equals(email)){
            throw new RuntimeException("You do not have permission to delete this exam.");
        }
        examRepository.delete(exam);
    }

    private ExamResponse mapToResponse(Exam exam) {
        return new ExamResponse(exam.getId(), exam.getSubject(), exam.getLocalDate(), exam.getUser().getEmail());
    }
}
