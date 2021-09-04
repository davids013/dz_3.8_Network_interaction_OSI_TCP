package me.davids013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private final static int PORT = Server.PORT;

    public static void main() throws IOException, InterruptedException {
        System.out.println("\tClient runned");
        String host = "netology.homework";
        InetAddress inetAddress = InetAddress.getByName(host);
        System.out.println("\t" + host + ", ip address: " + inetAddress.getHostAddress());
        try (Socket clientSocket = new Socket(host, PORT);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            writer.println(host + ", давай почитаем Теннисона");
            for (int i = 1; i < 8; i += 2) {
                if (i >= Ulysses.TEXT.length) break;
                writer.println(">>\t- " + Ulysses.TEXT[i]);
                printCorrectRespond(reader, "");
            }
//            printCorrectRespond(reader, "");
//            writer.println(">>\t- Бесплодных этих скал, под мирной кровлей");
//            printCorrectRespond(reader, "");
//            writer.println(">>\t- Учу законам этот темный люд? –");
//            printCorrectRespond(reader, "");
            writer.println("\tСпасибо. Хватит.");
            while (reader.readLine() != null);
        }
    }

    private static void printCorrectRespond(BufferedReader reader, String prefix)
            throws IOException, InterruptedException {
        String respond = reader.readLine();
        Thread.sleep(300);
        System.out.println(prefix + respond);
    }
}
