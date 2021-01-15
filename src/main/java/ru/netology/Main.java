package ru.netology;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        final var serverSocket = new ServerSocket(9999);
        new Server(serverSocket).connectServer();

    }

}



