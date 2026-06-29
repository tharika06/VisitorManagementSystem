# VisitorManagementSystem

A simple web-based Visitor Management System developed using JSP, Servlets, JDBC, and Oracle Database.
The application allows users to create and manage visitor records through a dynamic web interface.

---

# Technologies Used

* Java
* JSP
* Servlets
* JDBC
* Oracle Database
* HTML
* Apache Tomcat
* Eclipse IDE

---

# Features

* Create visitor records
* Fetch visitor records
* Fetch all visitor records
* Generate unique visitor ID
* Check if visitor record already exists using visitor name and date
* Store and retrieve visitor details from database

---

# Project Structure

```text id="m5r2zx"
VisitorManagementSystem/
│
├── src/main/java/com/trippro/visitor
│   │
│   ├── bean
│   │   └── VisitorBean.java
│   │
│   ├── dao
│   │   └── VisitorDAO.java
│   │
│   ├── servlet
│   │   └── MainServlet.java
│   │
│   └── util
│       └── DBUtil.java
│
├── src/main/webapp
│   ├── addVisitor.jsp
│   ├── displayAllVisitor.jsp
│   ├── displayVisitor.jsp
│   ├── error.html
│   ├── menu.html
│   ├── success.html
│   └── viewVisitor.jsp
```

---

# Functionality

* Add visitor details
* View visitor information
* View all visitor records
* Generate visitor ID automatically
* Validate duplicate visitor records using visitor name and date

---

# JSP Pages

| Page Name             | Purpose                     |
| --------------------- | --------------------------- |
| menu.html             | Main menu page              |
| addVisitor.jsp        | Add visitor details         |
| displayVisitor.jsp    | Display visitor information |
| displayAllVisitor.jsp | Display all visitor records |
| viewVisitor.jsp       | View visitor details        |
| success.html          | Success message page        |
| error.html            | Error handling page         |

---

# How to Run the Project

1. Import project into Eclipse IDE
2. Configure Apache Tomcat Server
3. Configure Oracle Database connection in `DBUtil.java`
4. Create required database tables in Oracle
5. Run the application on Tomcat Server
6. Open browser:

```text id="g9v3tp"
http://localhost:8080/VisitorManagementSystem
```

---

# Sample Operations

* Add Visitor
* View Visitor
* View All Visitors
* Generate Visitor ID
* Check Existing Visitor Records

---

# Author

Tharika
