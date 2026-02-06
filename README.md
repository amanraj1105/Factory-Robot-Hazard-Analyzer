# Factory Robot Hazard Analyzer

A console-based Java application that evaluates the hazard risk score of a factory robot based on arm precision, worker density, and machinery state.  
The project is developed **use-case wise (UC1–UC8)**, following **GitFlow** and core **OOPS principles**.

---

## 📌 Application Overview

The system calculates a **Robot Hazard Risk Score** using the formula:

Hazard Risk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor)


Supported machinery states (case-sensitive):
- Worn → 1.3
- Faulty → 2.0
- Critical → 3.0

Invalid inputs are handled using a **custom exception**.

---

## 🛠️ Technologies Used
- Java
- IntelliJ IDEA
- Git & GitFlow
- GitHub

---

## 🚀 Features (UC Summary)

- UC1: Display static system message
- UC2: Accept user inputs
- UC3–UC5: Hazard risk calculation & refactoring
- UC6: Custom exception (`RobotSafetyException`)
- UC7: Machinery risk mapping
- UC8: Fully modular, OOPS-compliant design

---

## 🧱 OOPS Principles Demonstrated
- Encapsulation
- Abstraction
- Single Responsibility Principle
- Modularity
- Exception-based control flow

---

## ▶️ How to Run

```bash
cd src
javac *.java
java FactoryRobotHazardAnalyzer