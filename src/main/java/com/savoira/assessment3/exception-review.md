# Exception Handling Code Review

## Original Code

```java
public void processPayment(double amount) {
    try {
        if (amount <= 0) throw new Exception("bad");
        // deduct from account
    } catch (Exception e) {
        // silent
    }
}
```

## Problems Identified

### 1. Generic `Exception` is used

**Severity: Major**

The code throws the generic `Exception` class. This does not clearly
communicate what type of error occurred and makes it harder for callers
to handle specific failures appropriately.

**Suggested Fix:**

Use a more specific exception that represents the problem. For an
invalid payment amount, `IllegalArgumentException` is appropriate.

```java
if (amount <= 0) {
    throw new IllegalArgumentException(
            "Payment amount must be greater than zero"
    );
}
```

### 2. The exception message is not meaningful

**Severity: Major**

The message `"bad"` does not explain why the payment was rejected.
Meaningful exception messages are important for debugging and
understanding failures.

**Suggested Fix:**

Use a descriptive message that tells the caller what is wrong.

```java
throw new IllegalArgumentException(
        "Payment amount must be greater than zero"
);
```

### 3. The exception is silently ignored

**Severity: Blocker**

The catch block does nothing:

```java
catch (Exception e) {
    // silent
}
```

This hides failures from the caller. Payment could fail while the
application continues as if nothing went wrong.

**Suggested Fix:**

Do not silently swallow exceptions. Allow a meaningful exception to
propagate or handle/log it appropriately.

### 4. No account balance validation

**Severity: Major**

The method indicates that the account will be debited, but it does not
check whether sufficient funds are available. This could allow a payment
that exceeds the account balance.

**Suggested Fix:**

Check the available balance before deduction and reject the payment if
there are insufficient funds.

### 5. The `try` block is unnecessary for input validation

**Severity: Minor**

Validation does not need a broad `try-catch` block. The method can
validate the amount and throw an appropriate exception directly.

**Suggested Fix:**

Perform validation before the operation and catch only exceptions that
can be meaningfully handled.

## Corrected Method

```java
public void processPayment(double amount) {

    if (amount <= 0) {
        throw new IllegalArgumentException(
                "Payment amount must be greater than zero"
        );
    }

    if (amount > balance) {
        throw new IllegalStateException(
                "Insufficient balance for payment"
        );
    }

    // Deduct from account only after all validation passes.
    balance -= amount;
}
```

## Explanation of the Correction

The corrected method follows a fail-fast approach.

1. It rejects zero or negative payment amounts.
2. It uses a specific exception instead of the generic `Exception`.
3. It provides meaningful exception messages.
4. It does not silently swallow failures.
5. It checks the account balance before deducting the payment.
6. The balance is changed only after the required validations pass.

This makes the payment operation easier to understand, debug, and
maintain while preventing invalid payment operations from being
silently ignored.
