#  StarBuzz Coffee Shop - Decorator Pattern Example

##  Project Overview
StarBuzz Coffee Shop is a Java-based console application designed to demonstrate the **Decorator Design Pattern**.  
This project models a coffee ordering system where beverages can be dynamically decorated with condiments such as Milk or Mocha.

It is implemented with **high standards** in logging, exception handling, defensive programming, and clean code structure.

---

##  Design Pattern: Decorator Pattern

The **Decorator Pattern** allows behavior to be added to an individual object dynamically without affecting the behavior of other objects from the same class.

**Key Benefits:**
- Flexible alternative to subclassing for extending functionality.
- Allows stacking of multiple decorators.
- Adheres to Open/Closed Principle.

**Core Components:**
1. **Component** — `Beverage` (abstract class).
2. **Concrete Components** — `Espresso`, `HouseBlend`.
3. **Decorator** — `CondimentDecorator` (abstract).
4. **Concrete Decorators** — `Milk`, `Mocha`.

---

##  How to Run

### Prerequisites:
- Java 8 or above installed.
- Maven or IDE (Eclipse, IntelliJ, VS Code, etc.).

### Steps:
1. Clone the repository:
```bash
git clone https://github.com/yourusername/StarBuzzCoffeeShop.git
Navigate to the project directory:

bash
Copy code
cd StarBuzzCoffeeShop
Compile and run:

bash
Copy code
javac -d bin src/Main.java
java -cp bin Main