package com.exam_scheduler.Exam_Scheduler;

import com.exam_scheduler.Exam_Scheduler.dto.ExamRequest;
import com.exam_scheduler.Exam_Scheduler.dto.ExamResponse;
import com.exam_scheduler.Exam_Scheduler.model.Exam;
import com.exam_scheduler.Exam_Scheduler.model.User;
import com.exam_scheduler.Exam_Scheduler.repository.ExamRepository;
import com.exam_scheduler.Exam_Scheduler.repository.UserRepository;
import com.exam_scheduler.Exam_Scheduler.service.ExamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ExamRepository examRepository;

    @InjectMocks
    private ExamService examService;

    @Test
    public void addExamTest() {
        User user = new User("nume", "nume@example.com", "pass", "USER");
        ExamRequest examRequest = new ExamRequest("Mate", LocalDate.now());

        when(userRepository.findByEmail("nume@example.com")).thenReturn(Optional.of(user));
        when(examRepository.save(any(Exam.class))).thenAnswer(invocation -> invocation.getArgument(0)); // returnează exam-ul salvat

        ExamResponse examResponse = examService.addExam("nume@example.com", examRequest);

        assertEquals("Mate", examResponse.getSubject());
        assertEquals("nume@example.com", examResponse.getUserEmail());
    }
}
