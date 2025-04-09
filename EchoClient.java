import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = 0;

        try {
            portNumber = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse the port number!");
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        BufferedReader stdIn = null;

        try {
            echoSocket = new Socket(hostName, portNumber);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Connected to echo server " + echoSocket.getInetAddress().getHostAddress()
                    + " on port " + echoSocket.getPort());

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        } finally {
            try {
                if (echoSocket != null)
                    echoSocket.close();
                if (out != null)
                    out.close();
                if (in != null)
                    in.close();
                if (stdIn != null)
                    stdIn.close();
            } catch (IOException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }

        System.out.println("Goodbye!");
    }
}
