package LessonN04;

import java.util.*;
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter server IP address: ");
        String serverAddress = in.nextLine();

        System.out.print("Enter server port number: ");
        String portInput = in.nextLine();

        try (
                Socket socket = new Socket(serverAddress, Integer.parseInt(portInput));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            System.out.println("Connected to server at " + serverAddress + ":" + portInput);

            String prompt = inFromServer.readLine();
            System.out.println(prompt);

            MessageReceiver handler = new MessageReceiver(inFromServer);
            new Thread(handler).start();

            BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
            String name = keyboardInput.readLine();
            out.println(name);

            String message;
            while ((message = keyboardInput.readLine()) != null) {
                out.println(message);
            }

        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}