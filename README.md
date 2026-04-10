# MiniUdemy - Microservices E-Learning Platform

A scalable e-learning platform built with microservices architecture, designed to manage users, teachers, courses and enrollments in a decoupled, event-driven system.

## Overview
MiniUdemy simulates a real-world online education platform where users can register, become teachers and create courses. The platform is split into independent microservices, each responsible for a single domain. Services communicate both synchronously via OpenFeign and asynchronously via Apache Kafka, ensuring loose coupling and high scalability.

## Architecture
```
Client Request
      ↓
API Gateway (8080)
      ↓
Netflix Eureka (Service Discovery)
      ↓
┌─────────────┬──────────────┬───────────────┬──────────────────┐
│ UserService │TeacherService│ CourseService  │ EnrollmentService│
└─────────────┴──────────────┴───────────────┴──────────────────┘
      ↓ Kafka Events
TeacherConsumerService
```

## Services

### UserService
- **UserGetService** — Handles user read operations. Fetches user details and queries users by ID or role.
- **UserPostService** — Handles user registration and update operations. On user save, publishes a Kafka event containing user data including role information.

### TeacherService
- **TeacherGetService** — Handles teacher read operations. Fetches teacher profiles and listings.
- **TeacherCommandService** — Handles teacher write operations such as creating and updating teacher records.
- **TeacherConsumerService** — Listens to Kafka events published by UserPostService. When a new user is registered with the role `TEACHER`, this service automatically creates a corresponding teacher record, enabling automatic teacher provisioning without direct service-to-service HTTP calls.

### CourseService
- **CourseGetService** — Handles course read operations. Lists all courses and fetches course details.
- **CoursePostService** — Handles course creation and update operations. Uses OpenFeign to validate teacher existence before saving a course.

### EnrollmentService
- **EnrollmentGetService** — Handles enrollment read operations. Lists enrollments by user or course.
- **EnrollmentPostService** — Handles enrollment creation. Uses OpenFeign to validate both user and course existence before persisting the enrollment record.

## Event-Driven Flow
```
UserPostService
    │
    │ publishes Kafka event (UserSavedEvent)
    │ { userId, name, email, role: TEACHER }
    ↓
TeacherConsumerService
    │
    │ consumes event
    │ checks role == TEACHER
    ↓
auto-creates Teacher record in TeacherDB
```

## API Routes
All requests go through the API Gateway at `http://localhost:8080`

| Service | Method | Base Path |
|---|---|---|
| CourseGetService | GET | `/api/read/courses/**` |
| CoursePostService | POST | `/api/update/courses/**` |
| TeacherGetService | GET | `/api/read/teachers/**` |
| TeacherCommandService | POST/PUT | `/api/update/teachers/**` |
| UserGetService | GET | `/api/read/users/**` |
| UserPostService | POST | `/api/update/users/**` |
| EnrollmentGetService | GET | `/api/find/enrollments/**` |
| EnrollmentPostService | POST | `/api/update/enrollments/**` |

## Service Registry
All services register themselves to Netflix Eureka on startup. The API Gateway discovers service instances dynamically via Eureka using `lb://SERVICE-NAME` load balancer URLs, eliminating hardcoded host/port dependencies.

## Getting Started

### Prerequisites
- Java 17
- PostgreSQL
- Apache Kafka & Zookeeper
- Maven

### Database Setup
Each service has its own isolated PostgreSQL database:

| Service | Database |
|---|---|
| UserService | `user-service-db` |
| TeacherService | `teacher-service-db` |
| CourseService | `course-service-db` |
| EnrollmentService | `enrollment-service-db` |

### Run Order
```bash
# 1. Start Zookeeper
# 2. Start Kafka
# 3. Start EurekaServer      → http://localhost:8761
# 4. Start all microservices
# 5. Start ApiGateway        → http://localhost:8080
```

## Tech Stack
| Category | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot |
| Service Discovery | Netflix Eureka |
| API Gateway | Spring Cloud Gateway |
| Async Messaging | Apache Kafka & Zookeeper |
| Sync Communication | OpenFeign |
| ORM | Hibernate / Spring Data JPA |
| Database | PostgreSQL |
| Build Tool | Maven Multi-Module |
| Version Control | Git |
