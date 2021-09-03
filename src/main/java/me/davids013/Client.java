package me.davids013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private final static int PORT = Server.PORT;

    public static void main() throws IOException {
        System.out.println("\tClient connected");
        String host = "localhost";
        InetAddress inetAddress = InetAddress.getByName(host);
        System.out.println("\t" + host + ", ip address: " + inetAddress.getHostAddress());
        try (Socket clientSocket = new Socket(host, PORT);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Get respond. Host: " + host);
            String resp = in.readLine();
            System.out.println("\t" + resp);
        }
    }

//    public static void main() {
//        String host = "127.0.0.1";
//        int port = 8089;
//
//        try(Socket clientSocket = new Socket(host, port);
//            PrintWriter out = new
//                    PrintWriter(clientSocket.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(new
//                    InputStreamReader(clientSocket.getInputStream()))) {
//
//            out.println("Netology");
//            String resp = in.readLine();
//            System.out.println(123 + resp);
//        }   catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
