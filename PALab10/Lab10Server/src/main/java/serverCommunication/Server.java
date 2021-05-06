package serverCommunication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Server {
    public static final int PORT = 8100;
    protected ServerSocket sSocket;
    protected List<String> people = new LinkedList<>();
    protected Map<String,List<String>> friendship = new HashMap<>();
    public Server() {
        try {
            sSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = sSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket, this).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { new Server(); }
}
