package serverCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private Server server;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String request = in.readLine();
                String[] command = request.split(" ", 2);
                if (command[0].equalsIgnoreCase("stop")) {
                    String raspuns = "Server stopped";
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    out.println(raspuns);
                    out.flush();
                    server.sSocket.close();
                } else {
                    processCommand(command);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

    private void processCommand(String[] command) {
        try {
            switch (command[0]) {
                case "register":
                    if (server.people.contains(command[1])) {
                        String raspuns = "User exists";
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                        out.println(raspuns);
                        out.flush();
                    }
                    else{
                        server.people.add(command[1]);
                        String raspuns = "User created";
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                        out.println(raspuns);
                        out.flush();
                    }
                    break;
                case "login":
                    if (server.people.contains(command[1])) {
                        String raspuns = "Logged In";
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                        out.println(raspuns);
                        out.flush();
                    }
                    else{
                        server.people.add(command[1]);
                        String raspuns = "Please register";
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                        out.println(raspuns);
                        out.flush();
                    }
                    break;
                case "friend":

                    break;
                case "send":
                    break;
                default:
                    String raspuns = "Unknown command! Try again!!";
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    out.println(raspuns);
                    out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
