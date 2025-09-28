# Abstract Factory Pattern - Theme Factory System

## Overview
This project demonstrates the Abstract Factory Design Pattern in Java.  
The system allows dynamic creation of UI components (Button, TextBox) based on a selected theme (Light or Dark).

## Structure
- `factory` → Contains abstract factory and concrete factories.
- `product` → Contains abstract products and concrete products.
- `client` → Application that uses factories to build UI.
- `main` → Application entry point.

## How it Works
1. User selects a theme at runtime.
2. The corresponding theme factory is created.
3. UI components are generated based on the selected theme.
4. UI is rendered dynamically.

## Key Features
- No hardcoded infinite loops.
- Validations for user input.
- Exception handling.
- Organized class structure.
- Demonstrates clean application of Abstract Factory Pattern.

## How to Run
```bash
javac -d bin src/**/*.java
java -cp bin main.App
