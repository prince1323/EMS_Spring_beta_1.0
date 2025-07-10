
Employee Management System (EMS) - Spring Boot
=============================================

📚 Overview
-----------
This is an **Employee Management System (EMS)** web application built with the **latest Spring Boot 3.5** framework.  
It follows the **Spring MVC + Front Controller architecture**, using **Thymeleaf** for views and **Spring Data JPA** with **MySQL** for persistence.  
Perfect as a learning and demo project for mastering Spring Boot 3.

🚀 Features
-----------
✅ Admin interface to manage employees and departments  
✅ Create, update, delete employee records  
✅ View employees by department  
✅ Thymeleaf-based server-side rendered UI  
✅ Uses Lombok for clean entity & DTO code  
✅ WAR packaging for flexible deployment on external servers

⚙️ Tech Stack
-------------
| Layer     | Technology                       |
|-----------|----------------------------------|
| Language  | Java 17                          |
| Backend   | Spring Boot 3.5.0, Spring MVC   |
| Database  | MySQL 8 (via mysql-connector-j) |
| ORM       | Spring Data JPA, Hibernate      |
| Frontend  | Thymeleaf, HTML, CSS            |
| Dev Tools | Spring Boot DevTools, Lombok    |
| Build     | Maven (packaged as WAR)         |

📂 Project Structure
---------------------
src/
 └── main/
     ├── java/
     │    └── com.ems/  (controllers, services, models, repos)
     └── resources/
          ├── templates/  (Thymeleaf HTML pages)
          ├── static/     (CSS, JS, images if any)
          └── application.properties
pom.xml

⚙️ Getting Started
-------------------

🔧 Prerequisites
- Java 17
- Maven
- MySQL 8 running locally

🚀 Run Locally

1️⃣ Clone the repository
    git clone https://github.com/prince1323/EMS_Spring_beta_1.0.git
    cd EMS_Spring_beta_1.0

2️⃣ Create the MySQL database
    CREATE DATABASE ems;

3️⃣ Update your database credentials in src/main/resources/application.properties:
    spring.datasource.url=jdbc:mysql://localhost:3306/ems
    spring.datasource.username=root
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

4️⃣ Build & run the project
    mvn clean install
    mvn spring-boot:run

5️⃣ Open in browser:
    http://localhost:8080/

🗂️ Key Functionalities
-----------------------
- `/` - Home / dashboard
- `/employees` - List employees
- `/employees/new` - Add employee
- `/employees/edit/{id}` - Edit employee
- `/employees/delete/{id}` - Delete employee
- `/departments` - View departments and their employees

🚀 Future Enhancements
-----------------------
✅ Integrate Spring Security for role-based access  
✅ REST APIs for frontend/mobile integration  
✅ Pagination, sorting & searching  
✅ Unit tests (Spring Boot Test starter already included)  
✅ Optionally use Oracle DB (ojdbc included in your pom.xml for future scope)


🛠 Developed by Prince Kumar
