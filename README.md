﻿<div align="center">
  <h1>SepMallSolution - Java Web Ordering System</h1>
</div>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue.svg" alt="Java Version"/>
  <img src="https://img.shields.io/badge/JSP%20%26%20Servlets-Web-yellow.svg" alt="JSP & Servlets"/>
  <img src="https://img.shields.io/badge/MySQL-Database-orange.svg" alt="MySQL"/>
  <img src="https://img.shields.io/badge/status-maintained-brightgreen.svg" alt="Status"/>
</p>

## 📝 Overview

SepMallSolution is a robust web-based ordering system built with Java, JSP, and Servlets, designed for efficient product ordering and management within a school or organizational setting. The system provides a user-friendly interface for students to browse products, place orders, and manage their accounts, while administrators can oversee user and product management.

## ✨ Key Features

* **User Authentication & Management:** Secure login and signup for students. Session management for user authentication.
* **Product Management:** Dynamic product listing fetched from a MySQL database. Product details include name, price, and image.
* **Order Placement:** Shopping cart functionality with the ability to add, remove, and update product quantities. Orders are processed and stored in the database.
* **Role-Based Access:** Students can place orders; administrators can manage products and view orders (admin features can be extended).
* **Modern UI:** Clean and responsive interface using JSP, CSS, and JavaScript.
* **Error Handling:** User-friendly error messages and feedback for failed logins, signups, and order issues.

## 🧑‍💻 User Roles & Dashboards

The application currently supports the following user roles:

### 1. Student/User Dashboard
   * Browse available products with images and prices.
   * Add products to a shopping cart and place orders.
   * View order status (feature can be extended).
   * Secure login/logout functionality.

### 2. Administrator (Extendable)
   * Manage product listings (CRUD operations can be added).
   * View all orders and user accounts (feature can be extended).

## 🛠️ Technical Requirements

### Software
* **Java:** Version 17 or higher.
* **Apache Tomcat:** Version 10.x recommended.
* **MySQL Server:** For database storage.
* **Maven:** For dependency and build management.

### Java Libraries & Dependencies
All dependencies are managed via Maven. Key dependencies include:
- `jakarta.servlet-api` (for Servlets)
- `org.mindrot:jbcrypt` (for password hashing)
- `org.slf4j:slf4j-api` and `ch.qos.logback:logback-classic` (for logging)

## 🚀 Setup and Installation

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/stultumJay/XU-SEP-Food-Tracker.git
    cd xu-sep-food-tracker
    ```

2. **Configure the Database:**
    - Ensure MySQL is running.
    - Use the provided SQL script at `src/main/webapp/table/schl.sql` to create the database and tables.
    - Update your database credentials in the `web.xml` context parameters.

3. **Build the Project:**
    ```bash
    mvn clean package
    ```

4. **Deploy to Tomcat:**
    - Copy the generated WAR file from `target/` to your Tomcat `webapps/` directory.
    - Start Tomcat and access the application at `http://localhost:8080/SepMall_OrderingSystem` (or your configured context path).

## ▶️ How to Run (Development)

- Import the project into your IDE (Eclipse/IntelliJ) as a Maven project.
- Configure Tomcat as your server and deploy the project.
- Access the app via your browser at the appropriate local URL.

## 📂 Directory Structure

A brief overview of the project's directory structure:

* `src/main/java/SepMallSolution/` - Java source code (servlets, models, DAO, utilities)
* `src/main/webapp/` - Web resources (JSPs, CSS, JS, images)
* `src/main/webapp/table/schl.sql` - SQL script for database setup
* `pom.xml` - Maven build configuration
* `README.md` - Project documentation

---
<p align="center"> Copyright &copy; 2025 Gerfel Jay Jimenez </p>
