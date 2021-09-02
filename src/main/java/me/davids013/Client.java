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
        System.out.println("Client connected");
        String host = "netology.ru";
        InetAddress inetAddress = InetAddress. getByName (host);
        System. out .println(host +  ", ip address: " +
                inetAddress.getHostAddress());
        try (Socket clientSocket =  new Socket(host, PORT);
             PrintWriter out =  new
                     PrintWriter(clientSocket.getOutputStream(),  true);
             BufferedReader in =  new BufferedReader( new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println("GET / HTTP/1.1 \n " + "Host: netology.ru \n\n\n");
                    String resp = in.readLine();
            System. out .println(resp);
        }
    }
}
