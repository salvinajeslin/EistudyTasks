README.md
#  Student Registration System (Builder Pattern)

##  Overview
This project demonstrates the **Builder Design Pattern** in Java with a real-world example of a **Student Registration System**.  
It was built as part of the **EiStudy Campus Drive** coding assignment.

The application allows:
- Registering new students
- Viewing all registered students
- Exiting safely with proper validations
- Asking user if they want to continue (`yes/no` input)

---

##  Features
- **Builder Pattern**: Used for step-by-step construction of `Student` objects.
- **Defensive Programming**: Validations included at every level.
- **Logging Mechanism**: Custom logger (`AppLogger`) implemented using `java.util.logging`.
- **Exception Handling**: Handles invalid inputs gracefully.
- **No `while(true)`**: Controlled execution with `yes/no` user input.
- **Scalable Structure**: Classes organized into packages (`model`, `util`, `client`).

---

##  How to Run
```bash
1️⃣ Clone the repository
git clone https://github.com/<your-username>/<repo-name>.git
2️⃣ Navigate to the project folder
bash
Copy code
cd <repo-name>
3️⃣ Compile the Java files
bash
Copy code
javac client/MainApp.java model/Student.java util/AppLogger.java
4️⃣ Run the program
bash
Copy code
java client.MainApp


Example Run

--- Student Registration System (Builder Pattern) ---
1. Register New Student
2. View All Students
3. Exit
Enter your choice: 1
Enter Name: John Doe
Enter Age: 21
Enter Department: Computer Science
Enter GPA (0.0 - 10.0): 8.7
Enter Email: john@example.com
Do you want to continue? (yes/no): yes