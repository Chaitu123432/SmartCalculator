# Code Review: transfer Method

## Code Under Review

```java
public void transfer(String from, String to, double amt) {
    try {
        accounts.get(from).setBalance(
                accounts.get(from).getBalance() - amt
        );

        accounts.get(to).setBalance(
                accounts.get(to).getBalance() + amt
        );
    } catch (Exception e) {
        // ignore
    }
}
```

## Problems Identified

### 1. Generic `Exception` is caught

**Severity: Major**

The method catches the generic `Exception` type. This hides the actual
cause of a failure and makes it difficult to handle different problems
correctly.

For example, a missing account and an invalid transfer amount are
different problems and should not be treated identically.

**Suggested Fix:**

Validate expected failure conditions explicitly and use specific
exceptions where appropriate.

### 2. Exceptions are silently ignored

**Severity: Blocker**

The catch block does nothing:

```java
catch (Exception e) {
    // ignore
}
```

This is dangerous in a banking operation. If an account does not exist
or another error occurs, the caller receives no indication that the
transfer failed.

A transfer could appear to have succeeded even though it did not.

**Suggested Fix:**

Do not silently swallow exceptions. Either allow an appropriate
exception to propagate or handle/log it meaningfully.

### 3. No validation for the source account

**Severity: Major**

The method assumes that `accounts.get(from)` always returns an account.
If the account ID does not exist, `accounts.get(from)` may return
`null`, resulting in a `NullPointerException`.

**Suggested Fix:**

Check that the source account exists before attempting the transfer.

### 4. No validation for the destination account

**Severity: Major**

The method also assumes that the destination account exists.

If the destination account is missing, the source balance may already
have been changed before the failure occurs.

**Suggested Fix:**

Validate both accounts before modifying either balance.

### 5. No validation of the transfer amount

**Severity: Major**

The method does not check whether `amt` is positive.

A zero or negative amount should not normally be accepted for a money
transfer. A negative amount could reverse the intended direction of the
transaction.

**Suggested Fix:**

Reject amounts that are less than or equal to zero.

```java
if (amount <= 0) {
    throw new IllegalArgumentException(
            "Transfer amount must be greater than zero"
    );
}
```

### 6. No insufficient-balance check

**Severity: Major**

The source account balance is reduced without checking whether it has
enough funds.

This could allow the source account to become negative.

**Suggested Fix:**

Check the source balance before performing the transfer.

```java
if (source.getBalance() < amount) {
    throw new IllegalStateException(
            "Insufficient balance"
    );
}
```

### 7. Source balance is modified before destination validation

**Severity: Blocker**

The source account is updated first:

```java
accounts.get(from).setBalance(
        accounts.get(from).getBalance() - amt
);
```

Only afterward is the destination account updated.

If the destination operation fails, the source balance may already have
been reduced. This creates an inconsistent state where money can
effectively disappear.

**Suggested Fix:**

Validate all conditions before changing either account. Ideally, the
transfer should behave as one atomic operation: either both balances are
updated or neither is changed.

### 8. Repeated map lookups reduce readability

**Severity: Minor**

The code repeatedly calls:

```java
accounts.get(from)
accounts.get(to)
```

This makes the method harder to read and unnecessarily repeats the map
lookup.

**Suggested Fix:**

Retrieve the accounts once and use descriptive local variables.

```java
Account source = accounts.get(from);
Account destination = accounts.get(to);
```

### 9. Parameter name `amt` is unclear

**Severity: Minor**

The abbreviation `amt` is less descriptive than `amount`.

**Suggested Fix:**

Use a descriptive parameter name:

```java
double amount
```

### 10. The method has no clear success/failure contract

**Severity: Major**

The method returns `void`, and because exceptions are silently ignored,
the caller has no reliable way to know whether the transfer succeeded.

**Suggested Fix:**

Use exceptions for failed transfers and allow successful completion to
represent a successful operation, or return an explicit result if the
application design requires one.

## Corrected Version

```java
public void transfer(String from, String to, double amount) {

    if (amount <= 0) {
        throw new IllegalArgumentException(
                "Transfer amount must be greater than zero"
        );
    }

    Account source = accounts.get(from);
    Account destination = accounts.get(to);

    if (source == null) {
        throw new IllegalArgumentException(
                "Source account not found: " + from
        );
    }

    if (destination == null) {
        throw new IllegalArgumentException(
                "Destination account not found: " + to
        );
    }

    if (source.getBalance() < amount) {
        throw new IllegalStateException(
                "Insufficient balance in source account"
        );
    }

    source.setBalance(source.getBalance() - amount);
    destination.setBalance(destination.getBalance() + amount);
}
```

## Explanation of the Correction

The corrected method follows a validation-first approach.

1. It rejects zero or negative transfer amounts.
2. It retrieves the source and destination accounts once.
3. It verifies that both accounts exist before changing any balance.
4. It checks that the source account has sufficient funds.
5. It uses descriptive variable and parameter names.
6. It does not silently swallow exceptions.
7. Both account balances are changed only after all required validation
   passes.

This makes the transfer operation easier to read, debug, and maintain
while reducing the risk of invalid or partially completed transfers.

## Overall Review

The original method has several important reliability problems,
especially the silent exception handling and the possibility of changing
the source balance before the destination transfer succeeds.

The main improvement is to **validate everything before modifying account
state** and to **never silently ignore exceptions**. This is especially
important for financial operations where an inconsistent balance can
cause serious data-integrity problems.
