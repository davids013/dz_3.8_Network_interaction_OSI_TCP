package me.davids013;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        Thread clientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Client.main();
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        clientThread.start();
        Server.main();
    }
}
