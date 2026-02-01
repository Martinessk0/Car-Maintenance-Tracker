# Car Maintenance Tracker - Backend

Spring Boot backend for tracking cars, fuel fill-ups, and maintenance expenses.

## Tech
- Spring Boot
- Spring Web (REST)
- Spring Data JPA (Hibernate)
- PostgreSQL (via Docker Compose)

## Run locally

### 1) Start Postgres
```bash
docker compose up -d
```

### 2) Run the app
```bash
./mvnw spring-boot:run
```

The API base URL is:
- `http://localhost:8080/api`

### Smoke test
- `GET http://localhost:8080/api/health` → `OK`

### Create a car
`POST http://localhost:8080/api/cars`
```json
{
  "make": "Mercedes-Benz",
  "model": "C300",
  "year": 2016,
  "vin": "55SWF4KBXGU130179",
  "licensePlate": "CB1234AB"
}
```
