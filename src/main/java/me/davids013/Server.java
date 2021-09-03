package me.davids013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8081;

    public static void main() throws IOException {
        System.out.println("Server started...");

        try
                (ServerSocket serverSocket = new ServerSocket(PORT);
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                ) {
            System.out.println("New connection");
            String message = reader.readLine();
            writer.println("Received: \"" + message + "\" from port " + clientSocket.getPort());
        }
    }

//    public static void main() throws Exception {
//        System.out.println("Server started");
//        int port = 8089;
//
//        while (true) {
//            ServerSocket serverSocket = new ServerSocket(port);
//            Socket clientSocket = serverSocket.accept();
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//
//            System.out.printf("New connection accepted, port %d%n", clientSocket.getPort());
//
//            final String name = in.readLine();
//            System.out.println(name);
//            out.println(String.format("Hi, %s. Your port is %d", name, clientSocket.getPort()));
//            //Thread.sleep(500);
//            System.out.println("Server stopped");
//            serverSocket.close();
//         }
//    }
}
