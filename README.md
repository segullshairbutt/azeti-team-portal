# Team Portal

A web application for managing team performance metrics and monitoring real-time activity feeds across your organization.

## Features

- **Dashboard**: View team statistics including member count, active projects, completed tasks, and efficiency metrics
- **Live Activity Feed**: Real-time feed of team activities with pause/resume functionality
- **User Profile**: View individual user profiles and their recent activity history

## Tech Stack

**Frontend**
- React 18
- TypeScript
- Vite
- React Router

**Backend**
- Kotlin
- Spring Boot 3
- Spring Data JPA
- H2 Database (in-memory)

## Prerequisites

- Node.js 18+
- Java 17+

## Getting Started

### 1. Install frontend dependencies

```bash
cd frontend
npm install
```

### 2. Start the backend

In a new terminal:

```bash
cd backend
./gradlew bootRun
```

The backend will start on `http://localhost:8080`

### 3. Start the frontend

In another terminal:

```bash
cd frontend
npm run dev
```

The frontend will start on `http://localhost:5173`

## Project Structure

```
├── frontend/               # Frontend application
│   ├── src/                # React source code
│   │   ├── components/     # React components
│   │   ├── api/            # API client
│   │   └── App.tsx         # Main application
│   ├── package.json
│   └── vite.config.ts
├── backend/                # Backend application
│   └── src/main/kotlin/    # Kotlin source files
└── README.md
```

## API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/teams/{team}/stats` | GET | Get statistics for a team |
| `/api/activities/feed` | GET | Get activity feed |
| `/api/users/{id}/activities` | GET | Get activities for a user |
