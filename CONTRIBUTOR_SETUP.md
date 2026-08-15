# 🛠️ Contributor Setup Guide — Project Aurora Backend

This guide walks you through setting up **Project Aurora**'s backend on your local machine, from installing prerequisites to running your first successful build. It's written for first-time contributors, with commands verified to work on **Windows**.

---

## 📖 Table of Contents

1. [Prerequisites](#1-prerequisites)
2. [Install Java 21](#2-install-java-21)
3. [Install Git](#3-install-git)
4. [Install PostgreSQL](#4-install-postgresql)
5. [Clone the Repository](#5-clone-the-repository)
6. [Create the `aurora_dev` Database](#6-create-the-aurora_dev-database)
7. [Configure `application.yaml`](#7-configure-applicationyaml)
8. [Run Flyway Migrations](#8-run-flyway-migrations)
9. [Start the Spring Boot Backend](#9-start-the-spring-boot-backend)
10. [Verify the Application Started Successfully](#10-verify-the-application-started-successfully)
11. [Troubleshooting](#11-troubleshooting)
12. [Next Steps](#12-next-steps)

---

## 1. Prerequisites

Before you begin, make sure you have:

- A Windows, macOS, or Linux machine (commands below are shown for **Windows**, with notes for macOS/Linux where they differ)
- Administrator access to install software
- A stable internet connection
- A GitHub account (to fork and clone the repository)

---

## 2. Install Java 21

Project Aurora's backend runs on **Java 21**.

### Windows

1. Download the Java 21 installer (Eclipse Temurin is recommended) from [https://adoptium.net](https://adoptium.net).
2. Run the installer and follow the setup wizard. Make sure **"Set JAVA_HOME variable"** is checked during installation.
3. Verify the installation:

   ```powershell
   java -version
   ```

   You should see output similar to:

   ```
   openjdk version "21.0.x"
   ```

### macOS / Linux

```bash
# macOS (Homebrew)
brew install openjdk@21

# Ubuntu/Debian
sudo apt update
sudo apt install openjdk-21-jdk
```

---

## 3. Install Git

### Windows

1. Download Git from [https://git-scm.com/download/win](https://git-scm.com/download/win).
2. Run the installer, keeping the default options unless you have a preference.
3. Verify installation:

   ```powershell
   git --version
   ```

### macOS / Linux

```bash
# macOS
brew install git

# Ubuntu/Debian
sudo apt install git
```

---

## 4. Install PostgreSQL

Project Aurora uses **PostgreSQL** as its primary database.

### Windows

1. Download the installer from [https://www.postgresql.org/download/windows/](https://www.postgresql.org/download/windows/).
2. Run the installer:
   - Set a password for the `postgres` superuser (remember this — you'll need it later).
   - Keep the default port `5432`.
   - Install **pgAdmin** if prompted (optional but useful for browsing the database visually).
3. Verify installation by opening **Command Prompt** and running:

   ```powershell
   psql --version
   ```

   > If `psql` is not recognized, add PostgreSQL's `bin` folder (e.g. `C:\Program Files\PostgreSQL\16\bin`) to your system `PATH`, then restart the terminal.

### macOS / Linux

```bash
# macOS
brew install postgresql@16
brew services start postgresql@16

# Ubuntu/Debian
sudo apt install postgresql postgresql-contrib
sudo systemctl start postgresql
```

---

## 5. Clone the Repository

1. Fork the repository on GitHub by clicking the **Fork** button on the [Project Aurora repository](https://github.com/).
2. Clone your fork locally:

   ```powershell
   git clone https://github.com/<your-username>/Project-Aurora.git
   cd Project-Aurora
   ```

3. Navigate to the backend application:

   ```powershell
   cd apps/backend
   ```

---

## 6. Create the `aurora_dev` Database

Open a terminal and connect to PostgreSQL using the `postgres` superuser:

```powershell
psql -U postgres
```

Enter the password you set during installation, then run:

```sql
CREATE DATABASE aurora_dev;
```

Confirm the database was created:

```sql
\l
```

You should see `aurora_dev` listed. Exit `psql`:

```sql
\q
```

> 💡 **Tip:** If you prefer a GUI, you can create the database using **pgAdmin** instead: right-click **Databases → Create → Database**, and name it `aurora_dev`.

---

## 7. Configure `application.yaml`

The backend reads its configuration from `application.yaml` (or `application.yml`), typically located at:

```
apps/backend/src/main/resources/application.yaml
```

If the project provides a template file (e.g. `application.example.yaml`), copy it first:

```powershell
copy src\main\resources\application.example.yaml src\main\resources\application.yaml
```

> On macOS/Linux, use `cp` instead of `copy`.

Update the datasource section with your local PostgreSQL credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/aurora_dev
    username: postgres
    password: your_postgres_password
  jpa:
    hibernate:
      ddl-auto: validate
  flyway:
    enabled: true
    locations: classpath:db/migration
```

> ⚠️ **Never commit your real credentials.** If `application.yaml` is tracked by Git, use environment variables or a local `application-local.yaml` (typically gitignored) instead.

---

## 8. Run Flyway Migrations

Project Aurora uses **Flyway** to manage database schema migrations.

From the `apps/backend` directory, run:

```powershell
.\mvnw.cmd flyway:migrate
```

> On macOS/Linux:
> ```bash
> ./mvnw flyway:migrate
> ```

If successful, you'll see output confirming each migration script that was applied, ending with something like:

```
Successfully applied X migration(s) to schema "public"
```

You can verify the tables were created by connecting to the database:

```powershell
psql -U postgres -d aurora_dev -c "\dt"
```

---

## 9. Start the Spring Boot Backend

From the `apps/backend` directory, run:

```powershell
.\mvnw.cmd spring-boot:run
```

> On macOS/Linux:
> ```bash
> ./mvnw spring-boot:run
> ```

Maven will download dependencies on the first run, which may take a few minutes.

---

## 10. Verify the Application Started Successfully

Once startup completes, you should see log output similar to:

```
Started AuroraApplication in X.XXX seconds
Tomcat started on port(s): 8080 (http)
```

Confirm the backend is running by visiting or curling the health endpoint:

```powershell
curl http://localhost:8080/actuator/health
```

Expected response:

```json
{"status":"UP"}
```

If you see this, your local backend setup is complete! 🎉

---

## 11. Troubleshooting

| Issue | Possible Cause | Fix |
|---|---|---|
| `java: command not found` | Java not installed or not on PATH | Reinstall Java 21 and ensure `JAVA_HOME` is set |
| `psql: command not found` | PostgreSQL `bin` not on PATH | Add PostgreSQL's `bin` directory to `PATH` |
| `FATAL: password authentication failed` | Wrong password in `application.yaml` | Double-check your `postgres` user password |
| `Connection refused` on port 5432 | PostgreSQL service not running | Start the PostgreSQL service (Windows Services app, or `brew services start` / `systemctl start`) |
| Flyway migration checksum mismatch | Local schema out of sync | Drop and recreate `aurora_dev`, then re-run migrations |
| Port 8080 already in use | Another process using the port | Stop the conflicting process, or change `server.port` in `application.yaml` |

---

## 12. Next Steps

Now that your backend is running locally:

- Review [`CONTRIBUTING.md`](./CONTRIBUTING.md) for the full contribution workflow.
- Check issues labeled `good first issue` or `help wanted`.
- Read the architecture and API documentation in the `docs/` folder.
- Set up the frontend (see the frontend setup guide, if available) to run the full stack.

Welcome aboard, and thank you for contributing to Project Aurora! ❤️
