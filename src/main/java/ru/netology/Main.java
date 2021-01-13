package ru.netology;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws IOException {

        final var validPaths = List.of("/index.html", "/spring.svg", "/spring.png");
        final var threadPool = Executors.newFixedThreadPool(64);

        System.out.println("Сервер начал работу");
        try {
            while (true) {

                var server = new Server(validPaths);
                threadPool.submit(server);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
