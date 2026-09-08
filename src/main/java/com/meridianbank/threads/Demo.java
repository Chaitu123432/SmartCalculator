package com.meridianbank.threads;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
                new NotificationDispatcher(
                        "ACC001",
                        "Your payment has been processed."
                ),
                "NotificationWorker-1"
        );

        Thread t2 = new Thread(
                new NotificationDispatcher(
                        "ACC002",
                        "Your account statement is ready."
                ),
                "NotificationWorker-2"
        );

        Thread t3 = new Thread(
                new NotificationDispatcher(
                        "ACC003",
                        "Your transfer was successful."
                ),
                "NotificationWorker-3"
        );

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All notifications dispatched.");
    }
}