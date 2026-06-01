# 🏥 Hospital Patient Management System

A desktop CRUD application for managing hospital patient records, built with Java Swing and MySQL. Allows hospital staff to add, view, update, delete, and print patient records through a clean GUI interface.

---

## ✨ Features

- ➕ **Add** new patient records
- 👁️ **View** all records in a live data table
- ✏️ **Update** existing patient information
- 🗑️ **Delete** patient records
- 🖨️ **Print** patient data
- 🔄 **Reset** form fields with one click
- 🎨 Custom styled Swing UI with Nimbus look and feel

---

## 🛠️ Tech Stack

| Layer     | Technology                        |
|-----------|-----------------------------------|
| Language  | Java (JDK 8+)                     |
| GUI       | Java Swing                        |
| Database  | MySQL                             |
| Connector | MySQL JDBC (`com.mysql.cj.jdbc.Driver`) |
| IDE       | Apache NetBeans                   |
| Build     | Apache Ant (`build.xml`)          |

---

## 🗃️ Database Schema

**Database:** `patients_db`  
**Table:** `patients_records`

```sql
CREATE DATABASE patients_db;

USE patients_db;

CREATE TABLE patients_records (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    FirstName   VARCHAR(100) NOT NULL,
    LastName    VARCHAR(100) NOT NULL,
    DateofBirth DATE,
    Email       VARCHAR(150),
    VisitReason VARCHAR(255),
    Gender      VARCHAR(20)
);
```

---

## ⚙️ Getting Started

### Prerequisites

- JDK 8 or higher
- MySQL Server running locally
- MySQL Connector/J (JDBC driver)
- Apache NetBeans IDE (recommended)

### Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/RelebogileMak/hospital_Db_System.git
   ```

2. **Set up the database**

   Open MySQL and run the SQL in the [Database Schema](#-database-schema) section above to create the database and table.

3. **Configure the DB connection**

   In `hospitalDbSystem/patients_db/src/patients_db/frmMain.java`, update the credentials to match your local MySQL setup:

   ```java
   private static final String dataConn = "jdbc:mysql://localhost:3306/patients_db";
   private static final String username  = "root";
   private static final String password  = "your_password";
   ```

4. **Add the MySQL JDBC driver**

   In NetBeans: right-click the project → **Properties** → **Libraries** → **Add JAR/Folder** → select your `mysql-connector-j-*.jar`.

5. **Open and run in NetBeans**

   - Open NetBeans → **File** → **Open Project**
   - Navigate to `hospitalDbSystem/patients_db/`
   - Hit **Run** (F6)

---

## 📁 Project Structure

```
hospital_Db_System/
├── hospitalDbSystem/
│   ├── src/
│   │   └── question_2/         # Initial prototype (attendance register)
│   │       ├── Question_2.java
│   │       └── frmMain.java
│   ├── patients_db/            # Main patients CRUD application
│   │   └── src/patients_db/
│   │       ├── Patients_db.java
│   │       └── frmMain.java
│   ├── patients_db1/           # Iteration/extended version
│   │   └── src/patients_db1/
│   │       ├── Patients_db1.java
│   │       └── frmMain.java
│   ├── Question_2/             # Standalone build of prototype
│   ├── nbproject/              # NetBeans project config
│   ├── build.xml               # Ant build file
│   └── manifest.mf
└── .gitignore
```

---

## 🚀 Future Improvements

- Doctor and ward management modules
- Patient appointment scheduling
- Search and filter functionality
- Login/authentication system
- Export records to PDF

---

## 👨‍💻 Author

**Relebogile Mak**
- GitHub: [@RelebogileMak](https://github.com/RelebogileMak)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
