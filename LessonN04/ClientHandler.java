package LessonN04;

import java.io.*;
import java.net.*;

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Enter your name: ");
            out.flush();

            clientName = in.readLine();

            if (clientName == null || clientName.isEmpty()) {
                out.println("Invalid name, disconnecting.");
                return;
            }

            System.out.println("Client " + clientName + " connected.");
            ChatServer.broadcastMessage(clientName + " has joined the chat.", this);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(clientName + ": " + message);
                ChatServer.broadcastMessage(clientName + ": " + message, this);
            }

        } catch (IOException e) {
            System.out.println("Error reading message from client " + clientName + ": " + e.getMessage());
        } finally {
            try {
                ChatServer.removeClient(this);
                ChatServer.broadcastMessage(clientName + " has left the chat.", this);
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
                if (clientSocket != null)
                    clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing client socket: " + e.getMessage());
            }
            System.out.println("Client disconnected: " + clientSocket.getInetAddress());
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}