package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String text ="Hello!";
        while (!text.equals("end") && text!=null) {
            text = newConnect(text);
            switch (text) {
                case "Let's talk":text="ok";break;
                case "where are you from?":text="from Russia";break;
                case "i, too":text="bye";break;
                case "bye":text="...";break;
                case "...":text="end";break;
                default:
                    text="end";
            }
        }
    }

    public static String newConnect(String text) {
        String host = "netology.homework";
        int port = 8888;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println(text);
            System.out.println("-> "+text);
            text = in.readLine();
            System.out.println("<- "+text);
            return text;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}