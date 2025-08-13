package com.exam_scheduler.Exam_Scheduler;

import com.exam_scheduler.Exam_Scheduler.model.User;
import com.exam_scheduler.Exam_Scheduler.repository.UserRepository;
import com.exam_scheduler.Exam_Scheduler.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    public void registerUserTest() {
        User user = new User("test", "test@exemplu.com", "parola", "USER");

        when(passwordEncoder.encode("parola")).thenReturn("encodedParola");
        when(userRepository.save(any(User.class))).thenAnswer(i -> i.getArgument(0));

        User savedUser = userService.registerUser(user);

        assertEquals("test@exemplu.com", savedUser.getEmail());
        assertEquals("encodedParola", savedUser.getPassword());
        assertNotEquals("parola", savedUser.getPassword());
    }
}
