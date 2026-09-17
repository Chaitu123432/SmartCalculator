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