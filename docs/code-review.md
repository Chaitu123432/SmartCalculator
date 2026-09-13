# Code Review Checklist

Before committing code, I check the following:

1. **Naming conventions**
    - Classes use PascalCase.
    - Methods and variables use camelCase.
    - Names clearly describe their purpose.

2. **Encapsulation**
    - Fields are private or protected where appropriate.
    - Classes expose only the behavior that is required.

3. **Exception handling**
    - Invalid user input is handled without crashing.
    - Mathematical errors use appropriate exceptions.
    - Error messages are clear and useful.

4. **Code duplication**
    - Repeated logic is extracted into reusable methods.
    - Methods have one clear responsibility.

5. **Documentation**
    - Public classes and methods contain Javadoc.
    - Javadoc includes appropriate `@param` and `@return` tags.

6. **Precision**
    - BigDecimal is used where floating-point precision could cause problems.

7. **Build verification**
    - `mvn compile` completes without errors.
    - The application can be run successfully from the command line.

## Self-Review

During the review, I identified duplicated number-parsing logic in `Main`.
I refactored the repeated `Double.parseDouble()` and exception-handling code
into the reusable `parseNumber()` method.

This reduced duplication and made the main input loop easier to read.