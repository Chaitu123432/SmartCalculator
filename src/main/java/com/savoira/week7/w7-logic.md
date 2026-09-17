# Week 7 — Logical Reasoning in Programming

## Task 1 — ATM Withdrawal Pseudocode

### Rules

The ATM must enforce the following rules:

1. Minimum withdrawal amount is Rs.500.
2. Maximum withdrawal amount is Rs.20,000.
3. Withdrawal amount must be a multiple of Rs.500.
4. The account must have sufficient balance.
5. The user gets a maximum of 3 attempts. After 3 failed attempts, the card is locked.

### Pseudocode

```text
START

balance ← 3000
attempts ← 0

WHILE attempts < 3

    INPUT withdrawalAmount
    attempts ← attempts + 1

    IF withdrawalAmount < 500 THEN
        DISPLAY "Minimum withdrawal is Rs.500"

    ELSE IF withdrawalAmount > 20000 THEN
        DISPLAY "Maximum withdrawal is Rs.20,000"

    ELSE IF withdrawalAmount MOD 500 ≠ 0 THEN
        DISPLAY "Amount must be a multiple of Rs.500"

    ELSE IF withdrawalAmount > balance THEN
        DISPLAY "Insufficient balance"

    ELSE
        balance ← balance - withdrawalAmount
        DISPLAY "Withdrawal successful"
        DISPLAY "New balance: " + balance
        STOP

END WHILE

DISPLAY "Card locked after 3 failed attempts"

END
```

The pseudocode uses descriptive variable names and common pseudocode symbols such as `←`, `MOD`, and `≠`. It is language-independent and is not tied to Java syntax.

---

## Task 2 — Flowchart

The ATM withdrawal flowchart is saved as:

`../../../../../../docs/atm-flowchart.png`

The flowchart contains decision diamonds for each conditional check:

- `attempts < 3?`
- `withdrawalAmount < 500?`
- `withdrawalAmount > 20000?`
- `withdrawalAmount MOD 500 ≠ 0?`
- `withdrawalAmount > balance?`

For each invalid withdrawal, the flow returns to the attempts check so the user can retry. After three failed attempts, the card is locked.

---

## Task 3 — Dry Run

Given:

```java
int balance = 3000;
int count = 0;
int[] txns = {500, -200, 1000, -300, 800};
```

The loop executes once for each transaction.

| Iteration | Transaction | Balance Before | Balance After | Positive? | Count After |
|---:|---:|---:|---:|:---:|---:|
| 1 | 500 | 3000 | 3500 | Yes | 1 |
| 2 | -200 | 3500 | 3300 | No | 1 |
| 3 | 1000 | 3300 | 4300 | Yes | 2 |
| 4 | -300 | 4300 | 4000 | No | 2 |
| 5 | 800 | 4000 | 4800 | Yes | 3 |

### Step-by-step

**Iteration 1**

```text
balance = 3000 + 500
        = 3500

500 > 0 → count = 1
```

**Iteration 2**

```text
balance = 3500 + (-200)
        = 3300

-200 > 0 → false
count = 1
```

**Iteration 3**

```text
balance = 3300 + 1000
        = 4300

1000 > 0 → count = 2
```

**Iteration 4**

```text
balance = 4300 + (-300)
        = 4000

-300 > 0 → false
count = 2
```

**Iteration 5**

```text
balance = 4000 + 800
        = 4800

800 > 0 → count = 3
```

---

## Task 4 — Final Output

The final values after the loop are:

```text
balance = 4800
count = 3
```

Therefore, the final output is:

```text
Balance: 4800
Deposits: 3
```

### Explanation

The starting balance is Rs.3000.

The transactions are:

```text
+500
-200
+1000
-300
+800
```

Therefore:

```text
3000 + 500 - 200 + 1000 - 300 + 800 = 4800
```

There are three positive transactions:

```text
500
1000
800
```

Therefore, the deposit count is `3`.
