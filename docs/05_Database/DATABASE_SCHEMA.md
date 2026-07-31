# Database Schema

## Overview

Project Aurora uses **PostgreSQL** as the primary relational database and **Flyway** for database versioning and schema migration.

The database is designed following normalization principles, scalability, and maintainability to support future platform growth.

---

# Current Database Version

| Version | Description | Status |
|----------|-------------|--------|
| V1 | Authentication Schema | ✅ Completed |

---

# V1 Authentication Schema

The first database migration establishes the authentication foundation for the platform.

## Tables

1. users
2. roles
3. user_roles

---

# Entity Relationship Diagram

```text
                USERS
                  │
                  │
             USER_ROLES
             │        │
             │        │
             ▼        ▼
           USERS    ROLES
```

---

# Table: users

## Purpose

Stores information common to every authenticated user of the platform.

Supported user types:

- Admin
- Instructor
- Student

A single user account may have multiple roles.

---

### Columns

| Column | Data Type | Constraints |
|---------|-----------|-------------|
| id | BIGSERIAL | Primary Key |
| first_name | VARCHAR(100) | NOT NULL |
| last_name | VARCHAR(100) | NOT NULL |
| email | VARCHAR(255) | UNIQUE, NOT NULL |
| password_hash | VARCHAR(255) | NOT NULL |
| profile_image_url | TEXT | NULL |
| bio | TEXT | NULL |
| is_active | BOOLEAN | DEFAULT TRUE |
| email_verified | BOOLEAN | DEFAULT FALSE |
| created_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |
| updated_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |

---

# Table: roles

## Purpose

Defines the system roles available within Project Aurora.

### Default Roles

| Role |
|------|
| ADMIN |
| INSTRUCTOR |
| STUDENT |

---

### Columns

| Column | Data Type | Constraints |
|---------|-----------|-------------|
| id | SMALLSERIAL | Primary Key |
| role_name | VARCHAR(50) | UNIQUE, NOT NULL |
| description | VARCHAR(255) | NOT NULL |
| created_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |

---

# Table: user_roles

## Purpose

Maps users to one or more system roles.

This table enables:

- Student
- Instructor
- Student + Instructor

using a single user account.

---

### Columns

| Column | Data Type | Constraints |
|---------|-----------|-------------|
| user_id | BIGINT | Foreign Key |
| role_id | SMALLINT | Foreign Key |
| assigned_at | TIMESTAMP | DEFAULT CURRENT_TIMESTAMP |

Composite Primary Key:

(user_id, role_id)

---

# Relationships

users (1) ----< user_roles >---- (1) roles

One user can have multiple roles.

One role can belong to multiple users.

---

# Business Rules

- Email must be unique.
- Passwords are stored only as hashed values.
- One user account can have multiple roles.
- Admin accounts cannot be created through public registration.
- Only predefined system roles are supported.
- Accounts are disabled using `is_active` instead of physical deletion.
- Email verification status is maintained using `email_verified`.

---

# Future Database Versions

| Version | Planned Features |
|----------|------------------|
| V2 | Categories & Courses |
| V3 | Instructor Profiles |
| V4 | Sections, Lessons & Videos |
| V5 | Enrollments & Payments |
| V6 | Live Classes |
| V7 | Progress Tracking |