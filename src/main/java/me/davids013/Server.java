package me.davids013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 1304;

    public static void main() throws IOException {
        System.out.println("Server started...");

        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("New connection");
        String message = reader.readLine();
        writer.println("Received: \"" + message + "\" from port " + clientSocket.getPort());
        serverSocket.close();
        clientSocket.close();
        writer.close();
    }
}
