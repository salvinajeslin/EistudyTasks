# SmartImageProxySystem

## Overview
The **SmartImageProxySystem** is a Java project demonstrating the **Proxy Design Pattern**.  
This system simulates an image viewer application where images are loaded on demand, optimizing performance and resource usage. The proxy pattern is used to control access to the real image objects, providing **lazy loading**, **validation**, and **logging**.

This project is designed with **gold standard practices**:
- Modular class structure
- Separate utility classes for logging and validation
- Proper exception handling
- Optimized performance
- Defensive programming
- No hardcoded infinite loops

---

## Design Pattern Used
**Proxy Pattern** — provides a surrogate or placeholder for another object to control access to it.  
In this project, `ProxyImage` acts as a proxy for `RealImage`, controlling access and improving performance.

---

## Key Features
- **Lazy loading** of images (loads only when needed)
- **Validation** for input files
- **Logging** of operations and errors
- **Exception handling**
- **Defensive programming** to prevent crashes
- Optimized for performance and reusability

---

## How to Run
1. Clone this repository:
```bash
git clone <repository-url>
Navigate to the project directory:

bash
Copy code
cd SmartImageProxySystem
Compile:

bash
Copy code
javac src/**/*.java
Run:

bash
Copy code
java src.App