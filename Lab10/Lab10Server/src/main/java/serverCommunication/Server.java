package serverCommunication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8100;

    public Server() {
        ServerSocket sSocket;
        try {
            sSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = sSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { new Server(); }
}
