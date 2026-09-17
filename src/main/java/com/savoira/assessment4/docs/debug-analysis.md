# Task B1.2: Debug Analysis for sumEvens

## Bug Identification & Explanation

1. **Bug 1: Incorrect Initial Accumulator Value (`int sum = 1;`)**
    - **Identification:** Tracing initial state showed an unexpected extra `+1` in the cumulative result.
    - **Explanation:** Sum accumulators must start at `0` (the additive identity). Starting at `1` offsets the entire sum by +1.

2. **Bug 2: Inverted Even Logic Condition (`if (i % 2 == 1)`)**
    - **Identification:** Tracing the loop execution showed odd numbers (1, 3, 5, 7, 9) being added instead of evens (2, 4, 6, 8, 10).
    - **Explanation:** `i % 2 == 1` tests for **odd** numbers. The condition for **even** numbers must be `i % 2 == 0`.