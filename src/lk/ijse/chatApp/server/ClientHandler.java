package lk.ijse.chatApp.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends  Thread {
    ArrayList<ClientHandler> clients;
    Socket socket;
    BufferedReader reader;
    PrintWriter Writer;

    public  ClientHandler(Socket accept, ArrayList<ClientHandler> clients){
      try {
          this.socket= socket;
          this.clients=clients;
          this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          this.Writer = new PrintWriter(socket.getOutputStream(), true);
      }catch(Exception e){
          System.out.println(e);
      }

    }

    public  void run(){

    }
}
