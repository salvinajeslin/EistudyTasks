# Fitness Tracker Notification System (Observer Pattern)

##  Overview
This project demonstrates the **Observer Design Pattern** using a **Fitness Tracker Notification System**.

In real life, fitness trackers monitor health data like **steps**, **heart rate**, and **sleep hours**.  
Whenever new data is recorded, different modules (Observers) get notified automatically without being tightly coupled to the tracker (Subject).

This follows the **Observer Pattern** principle:
> *"Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified automatically."*

---

##  Problem Statement
- The program should continuously accept fitness data inputs from the user.
- Observers should automatically react to updates in fitness data.
- No hardcoding of infinite loops like `while(true)`.
- Must follow **clean code practices**:
    - Separate classes for Subject, Observers, and Model.
    - Proper exception handling.
    - Validations and user-friendly interactions.
    - Easily extendable (new observers can be added without modifying core logic).

---

##  How It Works
1. **Subject**:
    - `FitnessTracker` acts as the **Subject**.
    - It maintains a list of observers and notifies them whenever new data is set.

2. **Observers**:
    - `GoalTrackerDisplay`: Tracks if the user reached 10,000 daily steps.
    - `HealthMonitorDisplay`: Alerts if the heart rate is abnormally high.
    - `SleepAnalyzerDisplay`: Analyzes if the user had enough sleep.

3. **Model**:
    - `FitnessData` stores fitness parameters (steps, heart rate, sleep hours).

4. **Driver App**:
    - `App.java` reads fitness data from the user and updates the tracker.
    - Observers are notified automatically.

---

##  Example Run
Enter fitness data: Steps HeartRate SleepHours
8500 90 5

Goal Tracker: Keep going! 1500 steps to go.
Health Monitor: Heart rate is normal.
Sleep Analyzer: You had less sleep. Try to sleep more.

Do you want to enter more data? (yes/no)
yes

Enter fitness data: Steps HeartRate SleepHours
12000 130 7

Goal Tracker: Congrats! You've reached your daily goal.
Health Monitor: High heart rate detected! Rest or consult doctor.
Sleep Analyzer: Sleep was good.

Do you want to enter more data? (yes/no)
no

Exiting Fitness Tracker. Goodbye!

yaml
Copy code

---

##  Key Features
- Implements **Observer Design Pattern** cleanly.
- User-friendly input (no infinite loop, user controls execution).
- Defensive programming with input validation.
- Extensible → new observers can be added without changing `FitnessTracker`.
- Clear separation of concerns with packages (`model`, `subject`, `observer`).

---

##  How to Run
1. Clone this repository:
   ```bash
   git clone <your-repo-link>
Navigate into the project folder and compile:

bash
Copy code
javac src/**/*.java
Run the program:

bash
Copy code
java App