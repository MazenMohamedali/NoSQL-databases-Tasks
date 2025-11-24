# 🚀 NoSQL Paradigm Labs

This repository serves as a comprehensive resource for practical tasks, code examples, and configurations related to the three major NoSQL database paradigms studied in the college lab: **Document**, **Column-Family (Wide-Column)**, and **Graph**.

This project demonstrates how to connect, model data, and perform queries using each distinct database type.

## 🎯 Repository Structure

The project is organized into three main directories, one for each NoSQL paradigm:

---

## 📚 Database Paradigms Covered

| Paradigm | Primary Database | Key Focus | Data Structure |
| :--- | :--- | :--- | :--- |
| **Document** | **MongoDB** | Flexible schema design, handling complex, nested data structures. | JSON/BSON Documents |
| **Column** | **Apache Cassandra** | Scalability, high availability, and **query-driven data modeling** using efficient partition keys. | Rows organized by Column Families |
| **Graph** | **Neo4j** | Modeling and traversing relationships (edges) between entities (nodes). | Nodes and Relationships |

---

## 💻 Setup and Execution

### 1. General Requirements

* **Java Development Kit (JDK 11+):** Required for all Java driver examples.
* **Maven or Gradle:** Used for managing necessary dependencies (e.g., MongoDB driver, Cassandra driver, Jackson library for JSON parsing).

### 2. Database Specific Setup

To run the tasks, you must have the corresponding database server running:

| Database | Default Connection URI | Setup Focus |
| :--- | :--- | :--- |
| **MongoDB** | `mongodb://127.0.0.1:27017` | Ensure the `mongod` service is active. |
| **Cassandra** | `127.0.0.1:9042` (Native Transport) | Ensure you have a running Cassandra node/cluster. |
| **Neo4j** | `bolt://localhost:7687` | Requires the Neo4j Desktop or server running. |

### 3. Running the Labs

1.  **Clone the Repository.**
2.  **Ensure Dependencies:** Use your build tool (Maven/Gradle) to download all required Java drivers.
3.  **Execute:** Navigate to the specific directory (e.g., `document/mongodb/java/`) and run the `Main` classes to execute the connection, data insertion, and query tasks.