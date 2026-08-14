# 🏗️ High-Level Design (HLD)

> Defines the overall architecture, major system components, technology stack, and interactions for Project Aurora.

---

![Status](https://img.shields.io/badge/Status-Draft-orange)
![Version](https://img.shields.io/badge/Version-0.1-blue)
![Phase](https://img.shields.io/badge/Phase-Solution%20Architecture-purple)

---

# 📄 Document Information

| Property | Value |
|----------|-------|
| Project | Project Aurora |
| Document | High-Level Design |
| Document ID | AUR-HLD-001 |
| Version | 0.1 |
| Status | Draft |
| Phase | Solution Architecture |
| Owner | Aurora Core Team |

---

# 🎯 Purpose

The High-Level Design (HLD) document defines the overall architecture of Project Aurora. It provides a high-level view of the system, identifies the major modules, describes how they interact, and establishes the technical foundation for implementation.

This document serves as the bridge between business requirements and software implementation.

---

# 🌍 System Overview

Project Aurora is an open-source learning platform that enables educators to create and deliver structured learning experiences while allowing students to enroll, learn, complete assessments, and track their progress.

Aurora is designed using a **Modular Monolith Architecture**, allowing independent modules to evolve while remaining within a single deployable application. This architecture balances maintainability, scalability, and simplicity, with the flexibility to migrate selected modules into microservices in the future if required.

---

# 🎯 Architectural Goals

- Build a modular and maintainable system.
- Support future scalability.
- Ensure security by design.
- Keep deployment simple.
- Enable independent module development.
- Support open-source collaboration.
- Minimize coupling between modules.

---

# 🏛️ Architecture Style

Aurora follows a **Modular Monolith Architecture**.

### Why Modular Monolith?

- Easier to develop and deploy than microservices.
- Clear separation of business modules.
- Better maintainability.
- Lower infrastructure complexity.
- Suitable for startups and open-source projects.
- Can evolve into microservices if required.

---

# 🧱 High-Level Architecture

```text
                    Users
                       │
        ┌──────────────┴──────────────┐
        │                             │
 Students / Instructors / Admins
                       │
                       ▼
              React Web Application
                       │
                HTTPS / REST API
                       │
      ┌──────────────────────────────────┐
      │      Aurora Backend              │
      │                                  │
      │ Identity Module                  │
      │ Course Module                    │
      │ Content Module                   │
      │ Learning Module                  │
      │ Assessment Module                │
      │ Analytics Module                 │
      │ Notification Module              │
      │ Commerce Module                  │
      │ Administration Module            │
      └──────────────────────────────────┘
                       │
                PostgreSQL Database
                       │
      ┌──────────────────────────────────┐
      │ External Services                │
      │                                  │
      │ Object Storage                   │
      │ Email Service                    │
      │ Payment Gateway                  │
      └──────────────────────────────────┘
```

---

# 🧩 System Modules

| Module | Responsibility |
|---------|----------------|
| Identity | Authentication, Authorization, User Management |
| Course | Course creation and management |
| Content | Videos, PDFs, Resources |
| Learning | Enrollment, Progress Tracking |
| Assessment | Quizzes and Assignments |
| Analytics | Reports and Dashboards |
| Commerce | Payments and Orders |
| Notification | Emails and Platform Notifications |
| Administration | Platform Management |

---

# 💻 Technology Stack

| Layer | Technology |
|--------|------------|
| Frontend | React + TypeScript |
| UI | Tailwind CSS + shadcn/ui |
| Backend | Spring Boot (Java 21) |
| Build Tool | Maven |
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Authentication | JWT + Refresh Tokens |
| API | REST |
| Object Storage | AWS S3 Compatible Storage |
| Containerization | Docker |
| Reverse Proxy | Nginx |
| CI/CD | GitHub Actions |
| Version Control | Git & GitHub |

---

# 🌐 External Integrations

| Integration | Purpose |
|-------------|---------|
| Email Service | Account verification and notifications |
| Object Storage | Store videos and learning resources |
| Payment Gateway | Process course purchases |
| GitHub | Source code management |
| Cloud Platform | Application hosting |

---

# 🔐 Security Overview

Aurora follows a security-first approach.

Key security measures include:

- JWT Authentication
- Role-Based Access Control (RBAC)
- Password Encryption (BCrypt)
- HTTPS Communication
- Input Validation
- Secure File Uploads
- Audit Logging
- Rate Limiting (Future)
- CSRF Protection (where applicable)

---

# 📈 Scalability Strategy

Aurora is designed to scale through:

- Modular architecture
- Stateless REST APIs
- External object storage
- Database indexing
- Caching (Future)
- Horizontal scaling of the backend
- CDN for static assets (Future)

---

# 🔄 Deployment Overview

```text
Developer
      │
      ▼
GitHub Repository
      │
GitHub Actions
      │
Docker Build
      │
Cloud Server
      │
Nginx
      │
Spring Boot Application
      │
PostgreSQL
```

---

# ⚠ Architectural Risks

| Risk | Mitigation |
|------|------------|
| Scope Growth | Modular feature planning |
| Performance Issues | Database optimization and caching |
| Security Threats | Security-first development |
| Large Video Storage | External object storage |
| Increased User Load | Horizontal scaling |

---

