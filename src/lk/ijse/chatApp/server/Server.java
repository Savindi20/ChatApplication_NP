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
