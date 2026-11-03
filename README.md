# Feedback Management System

A Java and Spring Boot coursework prototype for training-program and participant feedback workflows.

## Local configuration

The application requires PostgreSQL. Set these environment variables before starting it:

- DB_URL
- DB_USERNAME
- DB_PASSWORD
- APP_ADMIN_USERNAME
- APP_ADMIN_PASSWORD

JPA schema validation is enabled by default. Set JPA_DDL_AUTO only when you intentionally need another local behavior. Do not commit real credentials or use a development password on an internet-facing server.

The repository currently contains both a root Maven project and a duplicate project under cg/. The root Maven project is the intended entry point until the duplicate is consolidated.

## Current status

This is a learning project, not a production service. The API still needs controller/service wiring fixes, request DTO validation, per-role authorization, migration scripts, and automated business tests before deployment.