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