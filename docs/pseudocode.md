# Square Root Pseudocode

```text
FUNCTION squareRoot(number):
    IF number < 0 THEN
        THROW InvalidOperationException("Cannot sqrt a negative number")
    END IF

    RETURN Math.sqrt(number)
END FUNCTION
```

## Edge Case

If the input number is negative, the operation must not calculate a result. It throws `InvalidOperationException` with a clear message instead.
