package com.exam_scheduler.Exam_Scheduler.repository;

import com.exam_scheduler.Exam_Scheduler.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByUserEmail(String email);
}
