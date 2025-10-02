# Hello Vaadin – Demo App

This project is a simple **CRUD application** built with [Vaadin](https://vaadin.com/).  
It demonstrates common use cases and serves as an introduction to Vaadin development:

- Displaying data from a database in a **Grid**.
- Adding, editing, and deleting records via a **Form**.
- Handling **concurrent edits** directly in the UI with the **Collaboration Engine**.

The app is designed to be easy to understand and extend.

---

## Requirements

- **Java 21** or newer
- **Maven 3.9+**
- A modern browser (Chrome, Firefox, Safari, or Edge)

---

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/<your-user>/hello-vaadin.git
cd hello-vaadin
```

2. Build the project:

```bash
mvn clean install
```
3. Run the application:

```bash
mvn spring-boot:run
```

4. Open in browser:
http://localhost:8080

### Features

📊 CRUD with Grid and Form
- Displays a list of persons in a Grid.
- A Form is provided for editing the selected person.
- Persistence is handled with Spring Data JPA and an embedded H2 database.

🤝 Collaboration Engine
- Demonstrates how to handle concurrent edits directly in the UI.
- Built-in collaboration features to make multi-user scenarios visible.

⚡ Developer Experience
- Runs in Vaadin Development Mode for instant feedback.
- Supports HotSwap for fast iteration while coding.

⸻

Technology Stack
•	Spring Boot – Application backend & bootstrapping
•	Vaadin Flow – Java-based UI framework
•	Vaadin Collaboration Engine – Real-time collaboration and conflict handling
•	Spring Data JPA with H2 in-memory database

⸻