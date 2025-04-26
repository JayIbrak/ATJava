import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse the port number!");
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            serverSocket = new ServerSocket(portNumber);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("connection made with " + clientSocket.getInetAddress().getHostAddress());
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("received: " + inputLine);
                out.println(inputLine);
                if ("exit".equalsIgnoreCase(inputLine)) {
                    System.out.println("Exit command received. Closing connection.");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing server socket: " + e.getMessage());
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.err.println("Error closing input stream: " + e.getMessage());
                }
            }
        }
        System.out.println("Goodbye!");
    }
}
