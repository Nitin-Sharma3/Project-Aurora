# 🛠️ Development Environment Setup

## Document Information

| Property | Value |
|----------|-------|
| Document | Development Environment Setup |
| Version | 1.0 |
| Status | Approved |
| Project | Project Aurora |
| Audience | Contributors & Developers |
| Last Updated | 2026-07-29 |

---

# Purpose

This document explains how to set up a local development environment for Project Aurora.

Following this guide ensures every contributor uses a consistent environment, reducing setup issues and making collaboration easier.

---

# Minimum System Requirements

| Component | Requirement |
|----------|-------------|
| Operating System | Windows 11 / Linux / macOS |
| RAM | 8 GB Minimum (16 GB Recommended) |
| Processor | 64-bit |
| Storage | 10 GB Free Space |

---

# Development Tools

| Tool | Version |
|------|---------|
| Java | 21.0.12 LTS |
| Apache Maven | 3.9.16 |
| Node.js | 24.16.0 |
| npm | 11.13.0 |
| Git | 2.47.1 |
| Docker Desktop | 28.5.1 |
| Docker Compose | 2.40.0 |
| PostgreSQL | 18.4 |
| pgAdmin | Latest |

---

# Required Software

Install the following tools before contributing:

- Java 21 LTS
- Apache Maven
- Node.js
- Git
- Docker Desktop
- PostgreSQL
- pgAdmin

---

# Java Configuration

JAVA_HOME

```
C:\Program Files\Java\jdk-21.0.12
```

Verify:

```bash
java -version
javac -version
```

---

# Maven Configuration

MAVEN_HOME

```
C:\Program Files\Apache\Maven\apache-maven-3.9.16
```

Verify:

```bash
mvn -version
```

---

# PostgreSQL Configuration

| Property | Value |
|----------|-------|
| Version | PostgreSQL 18 |
| Port | 5433 |
| Username | postgres |
| Database | aurora_dev |
| Test Database | aurora_test |

Verify:

```bash
psql --version
```

---

# Node.js

Verify:

```bash
node -v
npm -v
```

---

# Docker

Verify:

```bash
docker --version
docker compose version
```

---

# Git

Verify:

```bash
git --version
```

---

# Environment Verification Checklist

- [x] Java Installed
- [x] JAVA_HOME Configured
- [x] Maven Installed
- [x] MAVEN_HOME Configured
- [x] Node.js Installed
- [x] Git Installed
- [x] Docker Installed
- [x] PostgreSQL Installed
- [x] pgAdmin Installed

---

# Repository Setup

Clone the repository

```bash
git clone https://github.com/praveenchapala/Project-Aurora.git
```

Navigate to the project

```bash
cd Project-Aurora
```

Create a feature branch

```bash
git checkout -b feature/<feature-name>
```

Never develop directly on the `main` branch.

---

# Development Workflow

1. Pull the latest changes.
2. Create a feature branch.
3. Implement the feature.
4. Test locally.
5. Commit using Conventional Commits.
6. Push the feature branch.
7. Open a Pull Request.
8. Merge only after review.

---

# Troubleshooting

## Java not found

Verify:

```bash
java -version
```

Check `JAVA_HOME` and `PATH`.

---

## Maven not found

Verify:

```bash
mvn -version
```

Check `MAVEN_HOME` and `PATH`.

---

## PostgreSQL not found

Verify:

```bash
psql --version
```

Ensure PostgreSQL's `bin` directory is added to the system `PATH`.

---

# Notes

Development environments should remain consistent across all contributors. If tool versions are updated, this document must be updated accordingly.