# Smart Office Facility Management System

##  Overview
This is a **console-based application** to manage a smart office facility.  
It allows users to:
- Book conference rooms
- Detect and manage room occupancy
- Automate air conditioning and lighting based on occupancy

This project demonstrates **object-oriented design**, **design patterns**, and **best coding practices**.

---

##  Tech Stack
- **Language:** Java (JDK 17+ recommended)
- **Build Tool:** Maven / Gradle (if configured) or direct `javac`
- **Design Patterns Used:** Singleton, Factory, Observer (based on implementation)

---

##  Features
-  Conference Room Booking
-  Occupancy Detection
-  Automated Control of AC & Lighting
-  Logging and Error Handling

---

## ▶️ How to Run
### Compile
```bash
javac -d out src/**/*.java
Run
bash
Copy code
java -cp out App

If using Maven:

bash
Copy code
mvn clean install
mvn exec:java -Dexec.mainClass="App"
