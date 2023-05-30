package lk.ijse.chatApp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends  Thread {
    ArrayList<ClientHandler> clients;
    Socket socket;
    BufferedReader reader;
    PrintWriter writer;

    public  ClientHandler(Socket socket, ArrayList<ClientHandler> clients){
      try {
          this.socket= socket;
          this.clients=clients;
          this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          this.writer = new PrintWriter(socket.getOutputStream(), true);
      }catch(Exception e){
          System.out.println(e);
      }

    }

    public  void run(){
        try {
            String message;
            while ((message = reader.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                for (ClientHandler cl : clients) {
                    cl.writer.println(message);
                    System.out.println(message);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
