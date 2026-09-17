# D2: Code Review

## Original Method

```java
public double x(double a, double b, int c) {
    double r = 1;
    for(int i=0;i<c;i++) {r = r*(1+b);}
    return a*r;
}
```

## Five Clean-Code Problems

1. **Meaningless method name** — `x` does not describe what the method calculates.
2. **Meaningless parameter names** — `a`, `b`, and `c` hide the meaning of the inputs.
3. **Meaningless local variable name** — `r` does not communicate what the value represents.
4. **Magic value / unclear initialization** — `1` is used without explaining that it is the initial compound-growth factor.
5. **Poor formatting and readability** — the loop is compressed onto one line and lacks standard spacing, making the method harder to read and maintain.

## Clean Rewrite

```java
public double calculateCompoundAmount(double principal, double rate, int periods) {
    double growthFactor = 1.0;

    for (int period = 0; period < periods; period++) {
        growthFactor *= 1.0 + rate;
    }

    return principal * growthFactor;
}
```

The rewritten method uses descriptive names, clear formatting, and separates the calculation into readable steps. The method preserves the original behavior: `rate` is expected as a decimal rate per period, such as `0.05` for 5%, and `periods` is the number of compounding periods.
