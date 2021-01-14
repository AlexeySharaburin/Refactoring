package ru.netology;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Executors;

public class Server {

    public Server() throws IOException {
        final var serverSocket = new ServerSocket(9999);
        final var threadPool = Executors.newFixedThreadPool(64);
        final var validPaths = List.of("/index.html", "/spring.svg", "/spring.png");

        System.out.println("Сервер начал работать!");

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    final var serverThread = new ServerThread(socket, validPaths);
                    threadPool.submit(serverThread);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();
    }
}

