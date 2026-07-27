# 🤝 Contributing to Project Aurora

First of all, thank you for considering contributing to **Project Aurora**.

Project Aurora is an open-source, production-oriented digital learning platform built by following professional Software Development Life Cycle (SDLC) practices. Our goal is not only to build a scalable learning platform but also to create a repository that demonstrates how real software products are designed, developed, tested, deployed, and maintained.

Every contribution—whether it's code, documentation, testing, design, bug reports, or feature ideas—helps improve the project.

---

# 📖 Table of Contents

- About Project Aurora
- Project Vision
- Ways to Contribute
- Before You Start
- Development Workflow
- Repository Structure
- Branching Strategy
- Commit Message Convention
- Coding Standards
- Documentation Standards
- Pull Request Process
- Code Review Guidelines
- Reporting Issues
- Suggesting Features
- Security Reporting
- Community Expectations
- Recognition
- Getting Help

---

# 🌟 About Project Aurora

Project Aurora is an open-source digital learning platform designed for:

- Individual educators
- Content creators
- Educational institutions
- Training organizations
- Students

The platform aims to provide a modern, scalable, and secure environment for managing digital education while following industry-standard software engineering practices.

---

# 🎯 Project Vision

Our vision is to build a production-ready platform that demonstrates:

- Clean Architecture
- Scalable Software Design
- Secure Development Practices
- High-Quality Documentation
- Modern UI/UX
- Professional Engineering Standards
- Open Source Collaboration

Every decision made in Aurora should prioritize long-term maintainability over short-term convenience.

---

# 🚀 Ways to Contribute

There are many ways to contribute:

### 💻 Code

- New features
- Bug fixes
- Performance improvements
- Refactoring

### 📚 Documentation

- Improve documentation
- Fix grammar
- Create diagrams
- Improve onboarding guides

### 🧪 Testing

- Write unit tests
- Integration tests
- UI testing
- Report bugs

### 🎨 Design

- UI improvements
- UX suggestions
- Accessibility improvements

### 💡 Ideas

- Feature requests
- Architecture suggestions
- Performance improvements

Every contribution matters.

---

# 📌 Before You Start

Please read the following documents before contributing:

- README.md
- Project Charter
- BRD
- Domain Model
- High-Level Design

Also:

- Check existing Issues.
- Search before creating duplicate Issues.
- Discuss major changes before implementation.

---

# 🔄 Development Workflow

Every contribution follows the same workflow.

```text
Fork Repository
        │
        ▼
Clone Repository
        │
        ▼
Create Feature Branch
        │
        ▼
Implement Changes
        │
        ▼
Run Tests
        │
        ▼
Update Documentation (if required)
        │
        ▼
Commit Changes
        │
        ▼
Push Branch
        │
        ▼
Open Pull Request
        │
        ▼
Code Review
        │
        ▼
Merge
```

---

# 📂 Repository Structure

```text
Project-Aurora/

apps/
    backend/
    frontend/

database/

docs/

infrastructure/

packages/

scripts/

assets/
```

| Directory | Purpose |
|------------|----------|
| apps | Backend and Frontend applications |
| database | Schema, migrations, seed data |
| docs | Project documentation |
| infrastructure | Docker, deployment, infrastructure |
| packages | Shared libraries and utilities |
| scripts | Automation scripts |
| assets | Images and static resources |

---

# 🌿 Branching Strategy

Never commit directly to the `main` branch.

Use descriptive branch names.

Examples:

```text
feature/authentication

feature/course-management

bugfix/login-validation

docs/update-readme

refactor/user-service
```

---

# 📝 Commit Message Convention

Aurora follows **Conventional Commits**.

Examples:

```text
feat(auth): implement JWT authentication

fix(course): resolve enrollment issue

docs(brd): update business requirements

refactor(api): simplify response handling

test(identity): add registration tests

chore(deps): update dependencies
```

---

# 💻 Coding Standards

All contributions should follow these principles:

- Write clean, readable code.
- Follow the existing architecture.
- Avoid duplicated logic.
- Use meaningful names.
- Keep methods focused on one responsibility.
- Prefer composition over duplication.
- Write comments only when necessary.
- Follow language-specific best practices.

---

# 📚 Documentation Standards

Documentation should:

- Be clear and concise.
- Stay synchronized with implementation.
- Use Markdown formatting consistently.
- Include diagrams when they improve understanding.
- Explain architectural decisions where appropriate.

---

# 🔀 Pull Request Process

Before opening a Pull Request:

- Ensure the project builds successfully.
- Run all relevant tests.
- Update documentation if needed.
- Keep the Pull Request focused on a single change.
- Reference related Issues.

Every Pull Request should include:

- Summary
- Reason for the change
- Testing performed
- Screenshots (if UI changes)

---

# 👀 Code Review Guidelines

Code reviews focus on:

- Correctness
- Readability
- Maintainability
- Security
- Performance
- Consistency with project architecture

Feedback is expected to improve the project, not criticize contributors.

---

# 🐛 Reporting Issues

When creating an Issue, include:

- Clear title
- Description
- Steps to reproduce
- Expected behavior
- Actual behavior
- Environment information
- Screenshots (if applicable)

---

# 💡 Suggesting Features

Feature requests should include:

- Problem statement
- Proposed solution
- Expected benefit
- Possible alternatives
- Additional context

Large features should be discussed before implementation.

---

# 🔒 Reporting Security Issues

Please do not report security vulnerabilities through public GitHub Issues.

Instead, contact the project maintainers privately so the issue can be investigated and resolved responsibly before public disclosure.

---

# 🤝 Community Expectations

We expect every contributor to:

- Be respectful.
- Be professional.
- Welcome constructive feedback.
- Help new contributors.
- Follow the project's Code of Conduct.
- Collaborate openly.

---

# 🏆 Recognition

Every accepted contribution helps improve Project Aurora.

Contributors may be recognized through:

- GitHub Contributors page
- Release notes
- Project acknowledgements

---

# ❓ Getting Help

If you have questions:

- Open a GitHub Discussion.
- Search existing Issues.
- Create a new Issue if needed.

We're happy to help contributors get started.

---

# ❤️ Thank You

Thank you for investing your time and effort in Project Aurora.

Whether you're fixing a typo, improving documentation, reporting a bug, or building a new feature, your contribution helps make Aurora a better platform for everyone.

Together, we're building more than software—we're building a community and a platform that demonstrates professional software engineering practices.
