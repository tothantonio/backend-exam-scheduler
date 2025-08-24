# 📅 Exam Scheduler

**Exam Scheduler** is a full-stack web application built with **Spring Boot** (Java) for the backend and **React** for the frontend.  
The app allows users to **register**, **log in**, and manage their **exams** in a personalized dashboard, with secure authentication using **JWT**.

---

- **User Registration & Login** with JWT authentication
- **Password encryption** using BCrypt
- **Personalized Dashboard** – each user sees only their own exams
- **CRUD Operations** for Exams (Create, Read, Update, Delete)
- **Validation** with DTOs to ensure data integrity
- **Error Handling** using `@ControllerAdvice`
- **Responsive Frontend** built with React + Axios + React Router
- **User Counter** – displays the total number of users in the app
- **Protected Routes** – only authenticated users can access the dashboard

---

**Backend**:
- Java 24
- Spring Boot 3 (Web, Security, Data JPA)
- JWT Authentication
- PostgreSQL Database
- Maven

**Frontend**:
- React (Vite)
- Axios
- React Router DOM
- CSS Modules

---

```
backend/
├── src/main/java/com/exam_scheduler/Exam_Scheduler
│    ├── dto/
│    ├── exception/
│    ├── controller/        # REST controllers
│    ├── model/             # Entities (User, Exam)
│    ├── repository/        # JPA repositories
│    ├── service/           # Business logic
│    ├── security/          # JWT config & filters
│    └── ExamSchedulerApplication.java
└── src/main/resources/
└── application.properties

frontend/
├── src/
│    ├── pages/             # Page-level components
│    ├── styling/
│    ├── App.jsx
│    └── main.jsx
└── public/

````

![1](https://github.com/tothantonio/frontend-exam-scheduler/blob/main/frontend/public/1.png?raw=true)

![2](https://github.com/tothantonio/frontend-exam-scheduler/blob/main/frontend/public/2.png?raw=true)


