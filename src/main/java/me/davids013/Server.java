package me.davids013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8081;

    public static void main() throws IOException, InterruptedException {
        System.out.println("Server started...");

        try
                (ServerSocket serverSocket = new ServerSocket(PORT);
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                ) {
            Thread.sleep(500);
            System.out.println("Установлено новое соединение");
            if (!printCorrectRequest(reader,
                    "Получен запрос из порта " + clientSocket.getPort() + " -> ")) return;
            System.out.println("...");
            Thread.sleep(1000);
            int stringCounter = 0;
            boolean isEnough = false;
            while(!isEnough && stringCounter < Ulysses.TEXT.length) {
                writer.println("<<\t- " + Ulysses.TEXT[stringCounter]);
                isEnough = !printCorrectRequest(reader, "");
                stringCounter += 2;
            }
        }


    }

    private static boolean printCorrectRequest(BufferedReader reader, String prefix)
            throws IOException, InterruptedException {
        String request = reader.readLine();
        if (request == null || request.isEmpty()
                || request.toLowerCase().contains("хватит")
                || request.toLowerCase().contains("достаточно")
                || request.toLowerCase().contains("прекрати")
                || request.toLowerCase().contains("остановись")
                || request.toLowerCase().contains("стоп")
        ) return false;
        Thread.sleep(1500);
        System.out.println(prefix + request);
        return true;
    }
}
