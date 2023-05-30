package lk.ijse.chatApp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
            static ArrayList<ClientHandler> clients=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        final int PORT = 8000;
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is Started..");

        System.out.println(
                "\uD83D\uDE04,\uD83D\uDE02,\uD83D\uDE22,\uD83E\uDD70," +
                "\uD83D\uDE18,\uD83D\uDE33,\uD83D\uDE1C,\uD83D\uDE2D," +
                "\uD83E\uDD14,\uD83D\uDE10,\uD83D\uDE0E,\uD83E\uDD73 ");

        while (true) {
            System.out.println("Server is Waiting for Clients");
            Socket localSocket = serverSocket.accept();
            System.out.println("Client is Connected..");
            ClientHandler clientHandler = new ClientHandler(localSocket, clients);
            clients.add(clientHandler);
            clientHandler.start();

        }
    }

}
