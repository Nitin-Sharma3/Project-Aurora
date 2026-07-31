# Development Log

---

## 2026-07-29 | Sprint 2 | Backend Foundation (Part 1)

### Time
- Start: 10:30 AM IST
- End: 12:45 PM IST

### Branch
feature/backend-foundation

### Completed
- Generated Spring Boot backend project.
- Created `apps/backend`.
- Added Spring Boot dependencies.
- Verified Maven Wrapper.
- Verified application startup.
- Identified PostgreSQL datasource configuration as the next step.
- Pushed feature branch to GitHub.

### Files Added
- apps/backend/**
- docs/development/DEVELOPMENT_SETUP.md

### Git
Branch:
feature/backend-foundation

Commit:
feat(backend): initialize Spring Boot backend foundation

### Next Session
- Configure `application.yml`
- Connect PostgreSQL
- Configure Flyway
- Verify successful application startup

---

# Development Log

---

## Date
**2026-07-30**

## Time
- **Start:** 11:10 AM IST
- **End:** 12:35 PM IST

## Sprint
**Sprint 2 – Backend Foundation (Part 2)**

## Branch
`feature/backend-foundation`

## Objective
Configure the Spring Boot backend and establish a successful connection with PostgreSQL.

## Work Completed

### PostgreSQL
- Verified PostgreSQL installation (18.4).
- Verified PostgreSQL service was running.
- Created a dedicated development database:
  - `aurora_dev`

### Spring Boot Configuration
- Configured `application.yaml`.
- Updated the application name to `aurora-backend`.
- Configured the PostgreSQL datasource.
- Configured Spring Data JPA.
- Configured Flyway.
- Configured server and logging properties.

### Backend Verification
- Successfully connected Spring Boot to PostgreSQL.
- HikariCP connection pool initialized successfully.
- Flyway initialized successfully.
- `flyway_schema_history` table created automatically.
- Embedded Tomcat started successfully on port `8080`.
- Backend application started successfully without errors.

## Files Modified

```text
apps/backend/src/main/resources/application.yaml
```

## Database

Created:

```text
aurora_dev
```

Flyway initialized:

```text
public.flyway_schema_history
```

## Challenges Faced

- PostgreSQL development database did not exist initially.
- Created and verified the `aurora_dev` database before configuring the backend.

## Outcome

- Backend is successfully running.
- Database connectivity verified.
- Flyway configured and operational.
- Aurora backend foundation is ready for database versioning.

## Next Session

**Sprint 2 – Backend Foundation (Part 3)**

Objectives:
- Create the first Flyway migration (`V1__initial_schema.sql`).
- Design Aurora's initial database schema.
- Execute the first database migration.
- Verify migration execution.
- Commit and push the completed milestone.

---
# Development Log

---

# Date

31 July 2026

---

# Sprint

Sprint 01 - Backend Foundation

---

# Feature Branch

feature/database-schema

---

# Completed Work

## Project Setup

- Configured Spring Boot backend.
- Configured PostgreSQL database.
- Configured Flyway database migration.
- Verified successful application startup.

---

## Database Design

Designed the authentication module for Project Aurora.

Finalized database entities:

- Users
- Roles
- User Roles

Designed relationships between authentication tables.

Documented authentication business rules.

---

## Database Migration

Created:

V1__initial_schema.sql

Implemented:

- users table
- roles table
- user_roles table

Inserted default system roles:

- ADMIN
- INSTRUCTOR
- STUDENT

---

## Flyway Migration

Successfully executed Flyway migration.

Migration Status:

- Version: V1
- Description: Initial Authentication Schema
- Status: Success

---

## Database Verification

Verified creation of:

- users
- roles
- user_roles
- flyway_schema_history

Verified default roles were inserted successfully.

---

## Architectural Decisions

### Authentication

- One account per user.
- One user can have multiple roles.
- Login uses email only.
- Passwords stored using hashed values.
- Admin accounts are not publicly registered.

---

### Database Design

- Normalized relational schema.
- Separate role mapping table.
- Authentication isolated from business modules.
- Instructor-specific information postponed to V3.

---

# Challenges Faced

None.

---

# Lessons Learned

- Flyway automatically manages schema versioning.
- Junction tables simplify many-to-many relationships.
- Designing before implementation produces a cleaner database architecture.
- Authentication should be separated from domain-specific modules.

---

# Next Tasks

- Create JPA entities.
- Create repository layer.
- Design authentication DTOs.
- Implement registration API.
- Implement login API.
- Configure Spring Security with JWT authentication.

---

# Status

✅ Sprint Completed Successfully
