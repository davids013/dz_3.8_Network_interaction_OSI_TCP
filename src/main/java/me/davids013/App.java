package me.davids013;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        Thread clientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1300);
                    Client.main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        clientThread.start();
        Server.main();
    }
}
