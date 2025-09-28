# CustomerSupportChain

##  Project Overview
**CustomerSupportChain** is a Java-based implementation of the **Chain of Responsibility design pattern**.  
The system simulates a customer support process where requests (complaints/issues) are passed through different support levels until resolved.

The chain contains three levels of support:
- **LevelOneSupport**
- **LevelTwoSupport**
- **LevelThreeSupport**

Each level checks if it can handle the request based on its severity level and either resolves it or passes it to the next handler in the chain.

---

##  Features
- Implements **Chain of Responsibility pattern** for handling support requests.
- Handles multiple levels of support dynamically.
- Centralized logging mechanism.
- User-friendly input handling with validation.
- Robust exception handling to ensure program stability.
- Modular and maintainable code structure.

---

##  How It Works
1. The application starts and initializes the chain of responsibility.
2. Users input a **support level** and a **message**.
3. Requests are passed through the chain:
    - If the current handler can process the request, it resolves it.
    - If not, it passes it to the next handler in the chain.
4. Process repeats until the request is handled or the chain ends.

---

##  Technologies Used
- **Java 17**
- OOP Principles
- Chain of Responsibility Design Pattern

---

## 🚀 How to Run
1. Clone the repository
Navigate to the project directory:

    ```bash
    Copy code
    cd CustomerSupportChain
    Compile the Java files:

    Copy code
    javac -d bin src/**/*.java
    Run the application:

    Copy code
    java -cp bin main.App
---
## Sample Interaction
yaml
Copy code
[2025-09-28 11:05:12] CustomerSupportChain system starting...

Enter support level (1, 2, 3) or 0 to exit:
1
Enter your support message:
Password reset request
[2025-09-28 11:05:18] LevelOneSupport: Handling request - Password reset request

Enter support level (1, 2, 3) or 0 to exit:
3
Enter your support message:
System outage complaint
[2025-09-28 11:05:25] LevelOneSupport: Passing request to LevelTwoSupport.
[2025-09-28 11:05:25] LevelTwoSupport: Passing request to LevelThreeSupport.
[2025-09-28 11:05:25] LevelThreeSupport: Handling request - System outage complaint

Enter support level (1, 2, 3) or 0 to exit:
0
[2025-09-28 11:05:30] Exiting system...