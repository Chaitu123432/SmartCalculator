package com.meridianbank.threads;

public class NotificationDispatcher implements Runnable {

    private final String accountId;
    private final String message;

    public NotificationDispatcher(String accountId, String message) {
        this.accountId = accountId;
        this.message = message;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();

        System.out.println(
                threadName + " | Dispatching to " + accountId
        );

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println(
                threadName + " | Sent: " + message
        );
    }
}