package com.savoira.assessment;

/**
 * Immutable account holder details.
 *
 * Immutability is useful for an AccountHolder in a banking context because
 * identity details cannot be changed accidentally after creation, making the
 * object safer to share and reason about across banking operations.
 */
public final class AccountHolder {

    private final String name;
    private final String customerId;
    private final String email;

    /**
     * Creates an immutable account holder.
     *
     * @param name account holder name
     * @param customerId unique customer identifier
     * @param email account holder email address
     */
    public AccountHolder(String name, String customerId, String email) {
        if (name == null || name.isBlank() || customerId == null || customerId.isBlank()
                || email == null || email.isBlank()) {
            throw new IllegalArgumentException("Name, customer ID and email cannot be null or blank");
        }
        this.name = name;
        this.customerId = customerId;
        this.email = email;
    }

    /**
     * Returns the account holder name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the customer ID.
     *
     * @return customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Returns the email address.
     *
     * @return email address
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "AccountHolder[name=" + name + ", customerId=" + customerId + ", email=" + email + "]";
    }
}
