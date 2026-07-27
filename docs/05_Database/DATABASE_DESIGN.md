# 🗄️ Database Design

> Defines the database architecture, schemas, entities, relationships, constraints, and design principles for Project Aurora.

---

![Status](https://img.shields.io/badge/Status-Draft-orange)
![Version](https://img.shields.io/badge/Version-0.1-blue)
![Phase](https://img.shields.io/badge/Phase-Database%20Design-purple)

---

# 📄 Document Information

| Property | Value |
|----------|-------|
| Project | Project Aurora |
| Document | Database Design |
| Document ID | AUR-DB-001 |
| Version | 0.1 |
| Status | Draft |
| Database | PostgreSQL |
| Owner | Aurora Core Team |

---

# 🎯 Purpose

This document defines the logical database design for Project Aurora.

It serves as the foundation for:

- Backend Development
- API Development
- Data Integrity
- Performance Optimization
- Database Implementation

---

# 🌍 Database Overview

Aurora uses a relational database based on PostgreSQL.

The database is designed using normalization principles while maintaining scalability and performance.

The design follows the Domain Model and Modular Monolith architecture.

---

# 🏛 Database Design Principles

- Normalized data model (up to 3NF where appropriate)
- UUID-based primary keys
- Foreign key constraints
- Soft deletes where required
- Audit fields on every table
- Minimal redundancy
- Clear naming conventions
- Security-first design

---

# 💻 Database Technology

| Component | Technology |
|-----------|------------|
| Database | PostgreSQL |
| ORM | Spring Data JPA / Hibernate |
| Migration Tool | Flyway |
| Connection Pool | HikariCP |

---

# 🧩 Database Modules

Aurora's database is organized into logical business domains.

| Module | Tables |
|----------|---------|
| Identity | users, roles, permissions |
| Course | courses, modules, lessons, resources |
| Learning | enrollments, progress, certificates |
| Assessment | quizzes, questions, submissions |
| Commerce | orders, payments |
| Communication | notifications |

---

# 📚 Entity Relationship Overview

```text
User
 │
 ├── Role
 │
 ├── Enrollment
 │        │
 │        ▼
 │      Course
 │         │
 │      Module
 │         │
 │      Lesson
 │         │
 │     Resource
 │
 ├── Certificate
 │
 ├── Order
 │
 ├── Payment
 │
 └── Notification
```

---

# 🔑 Primary Entities

| Entity | Description |
|----------|-------------|
| User | Platform user |
| Role | User permissions |
| Course | Learning program |
| Module | Course section |
| Lesson | Learning content |
| Resource | Video / PDF / File |
| Enrollment | Student enrollment |
| Progress | Course progress |
| Assessment | Quiz / Assignment |
| Certificate | Completion certificate |
| Order | Purchase record |
| Payment | Payment transaction |
| Notification | User notification |

---

# 🔗 Relationships

| Parent | Child | Relationship |
|---------|--------|--------------|
| Role | User | One-to-Many |
| User | Course | One-to-Many |
| Course | Module | One-to-Many |
| Module | Lesson | One-to-Many |
| Lesson | Resource | One-to-Many |
| User | Enrollment | One-to-Many |
| Course | Enrollment | One-to-Many |
| Enrollment | Progress | One-to-One |
| Enrollment | Certificate | One-to-One |
| User | Order | One-to-Many |
| Order | Payment | One-to-One |
| User | Notification | One-to-Many |

---

# 📋 Naming Conventions

| Item | Convention |
|------|------------|
| Tables | snake_case (users, courses) |
| Columns | snake_case |
| Primary Keys | id |
| Foreign Keys | entity_id |
| Timestamps | created_at, updated_at |
| Boolean | is_active, is_deleted |

---

# 🛡 Constraints

- Every User must have one Role.
- Every Course belongs to one Instructor.
- Every Module belongs to one Course.
- Every Lesson belongs to one Module.
- Students cannot enroll twice in the same course.
- Payments are mandatory for paid courses.
- Certificates are generated only after successful completion.

---

# ⚡ Indexing Strategy

Indexes will be created on:

- email
- username
- course_id
- instructor_id
- enrollment_id
- created_at

Composite indexes will be introduced based on query analysis.

---

# 🔒 Security Considerations

- Passwords stored using BCrypt hashing.
- No plaintext passwords.
- Sensitive data encrypted where necessary.
- Parameterized queries via JPA.
- Principle of least privilege for database access.

---

# 📈 Scalability Strategy

- UUID primary keys.
- Optimized indexing.
- Pagination for large datasets.
- Lazy loading where appropriate.
- External object storage for videos.
- Read replicas (future).

---

# 🚀 Future Enhancements

- Multi-tenancy
- Audit history
- Full-text search
- Redis caching
- Elasticsearch integration
- Database sharding (if required)

---

# 📝 Revision History

| Version | Date | Description |
|----------|------|-------------|
| 0.1 | 2026-07-27 | Initial Database Design |