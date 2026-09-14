# SmartCalculator Requirements

## 5 Whys

**Why does a user need a calculator app?**  
To perform arithmetic calculations quickly.

**Why does the user need quick calculations?**  
To avoid performing repetitive calculations manually.

**Why avoid manual calculations?**  
Manual calculations can take longer and can introduce arithmetic errors.

**Why reduce arithmetic errors?**  
Accurate results make the calculator more useful and reliable.

**Why is reliability important?**  
Users should be able to perform common calculations with predictable results and clear error handling.

### Insight

The calculator should prioritize simple arithmetic, reliable results, clear error messages, and a straightforward CLI.

## Functional Requirements

- FR1: The calculator shall support `+`, `-`, `*`, `/`, and `%` operations.
- FR2: The user shall enter two numbers and an operator through the CLI.
- FR3: The calculator shall continue running until the user types `exit`.
- FR4: Division by zero shall produce a clear error without crashing.
- FR5: The calculator shall display results to two decimal places.
- FR6: Invalid numeric input shall produce a clear error without crashing.
- FR7: Unsupported operators shall produce a clear error without crashing.
- FR8: The calculator shall validate the operator before creating the operation object.

## Non-Functional Requirements

- NF1: Each calculation should complete and display within one second.
- NF2: Error messages should be human-readable.
- NF3: The code should use clear naming and separation of responsibilities.

## Out of Scope

- No graphical user interface for Weeks 3–7.
- No web server.
- No database.
- No JavaScript-based application logic.
- No external calculation service.

## Planned Architecture

```text
Main
  |
  +--> Calculator
  |      |
  |      +--> operator validation
  |      +--> percentage utility
  |      +--> square-root utility
  |
  +--> Calculable
          |
          +--> Addition
          +--> Subtraction
          +--> Multiplication
          +--> Division
```
