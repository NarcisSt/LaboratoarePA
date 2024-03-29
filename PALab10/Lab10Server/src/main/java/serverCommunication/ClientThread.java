package serverCommunication;

import coloring.Greedy;
import lombok.EqualsAndHashCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
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
                    socket.shutdownOutput();
                    socket.shutdownInput();
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
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            switch (command[0]) {
                case "register":
                    if (server.users.contains(command[1])) {
                        sendMessage(out, "User exists");
                    } else {
                        server.users.add(command[1]);
                        sendMessage(out, "User created. Please login.");
                    }

                    break;
                case "login":
                    if (server.users.contains(command[1])) {
                        if (server.login.containsKey(this.socket)) {
                            sendMessage(out, "You are logged!");
                        } else {
                            server.login.put(this.socket, command[1]);
                            sendMessage(out, "Logged In");
                        }
                    } else {
                        sendMessage(out, "Please register");
                    }
                    break;
                case "friend":
                    String[] friends = command[1].split(" ");
                    if (server.friendship.containsKey(server.login.get(this.socket))) {
                        Set<String> newFriends = server.friendship.get(server.login.get(this.socket));
                        for (String friend : friends) {
                            newFriends.add(friend);
                        }
                        server.friendship.replace(server.login.get(this.socket), newFriends);
                        sendMessage(out, "Server received the request ... ");
                    }
                    else{
                        Set<String> newFriends = new HashSet<>();
                        for (String friend : friends) {
                            newFriends.add(friend);
                        }
                        server.friendship.put(server.login.get(this.socket), newFriends);
                        sendMessage(out, "Server received the request ... ");
                    }
                    break;
                case "send":
                    Set<String> myFriends = server.friendship.get(server.login.get(this.socket));
                    Set<Socket> keySocket = server.login.keySet();
                    for (Socket friend: keySocket){
                        if(myFriends.contains(server.login.get(friend))){
                            sendMessage(new PrintWriter(friend.getOutputStream()),command[1]);
                        }
                    }
                    sendMessage(out, "Server send messages to your friends ... ");
                    break;
                case "exit":
                    server.login.remove(this.socket);
                    sendMessage(out, "User disconnected");
                    socket.shutdownOutput();
                    break;
                case "cohesion":
                    Greedy greedyColoring = new Greedy(server.friendship);
                    int minim = greedyColoring.minimColor();
                    sendMessage(out, "Minim users to delete to create more than 1 connected components is " + minim);
                    break;
                default:
                    sendMessage(out, "Unknown command! Try again!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(PrintWriter out, String raspuns) {
        out.println(raspuns);
        out.flush();
    }
}
