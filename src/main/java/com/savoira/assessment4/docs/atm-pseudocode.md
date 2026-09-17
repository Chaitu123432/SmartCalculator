# Task A1.1: ATM Withdrawal Pseudocode

BEGIN ATMSimulator
SET balance = 10000.0
SET attempts = 0
SET maxAttempts = 3
SET cardLocked = FALSE

    WHILE attempts < maxAttempts AND cardLocked == FALSE DO
        READ amount FROM user

        IF amount < 500 THEN
            PRINT "Error: Minimum withdrawal amount is ₹500."
            INCREMENT attempts BY 1
        ELSE IF amount > 20000 THEN
            PRINT "Error: Maximum withdrawal amount is ₹20,000."
            INCREMENT attempts BY 1
        ELSE IF amount MOD 500 != 0 THEN
            PRINT "Error: Amount must be in multiples of ₹500."
            INCREMENT attempts BY 1
        ELSE IF amount > balance THEN
            PRINT "Error: Insufficient balance."
            INCREMENT attempts BY 1
        ELSE
            SET balance = balance - amount
            PRINT "Withdrawal successful! Dispensed: ₹" + amount
            PRINT "Updated Balance: ₹" + balance
            EXIT LOOP
        END IF

        IF attempts == maxAttempts THEN
            SET cardLocked = TRUE
            PRINT "Card locked due to 3 failed attempts."
        ELSE
            PRINT "Remaining attempts: " + (maxAttempts - attempts)
        END IF
    END WHILE
END ATMSimulator