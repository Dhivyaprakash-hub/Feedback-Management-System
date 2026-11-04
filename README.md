# Feedback Management API

A rebuilt training-feedback service using Java 21 and Spring Boot. It replaces the coursework’s broken controllers and duplicate project copy with a small, documented API for surveys and anonymous ratings. Responses contain only 1–5 scores and a recommend flag; the service does not collect names, employee IDs, email addresses, or free-text comments. Results are suppressed until a survey has five responses.

## Run locally

Install Java 21. The Maven Wrapper downloads the pinned Maven build tool the first time you use it.

Windows:

```powershell
./mvnw.cmd spring-boot:run
```

macOS/Linux:

```sh
./mvnw spring-boot:run
```

The default H2 database is in-memory and includes two sample surveys. API health is at `http://localhost:8080/actuator/health`.

Local demo keys are shown below. Replace them in any shared environment:

- Submission: `local-demo-key-change-before-deploy`
- Survey administration: `local-admin-key-change-before-deploy`

## API

- `GET /api/v1/surveys` — list survey metadata
- `POST /api/v1/surveys` — create a survey with `X-Admin-Key`
- `POST /api/v1/surveys/{id}/responses` — submit anonymous 1–5 scores with `X-Submission-Key`
- `GET /api/v1/surveys/{id}/summary` — view rounded aggregate results after five responses

Example response:

```json
{"contentScore":5,"trainerScore":4,"materialsScore":4,"wouldRecommend":true}
```

Set `FEEDBACK_ADMIN_KEY` and `FEEDBACK_SUBMISSION_KEY` to strong secret values before sharing the API. PostgreSQL can be configured with `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD`; Flyway manages schema versions and Hibernate validates them.

## Production boundary

The API does not expose individual responses. The static shared-key mechanism is suitable for a contained demo, not a public identity system. Before public use, add user/role authentication for survey administrators, short-lived submission tokens, edge rate limits and abuse monitoring, retention controls, and an explicit privacy policy.
