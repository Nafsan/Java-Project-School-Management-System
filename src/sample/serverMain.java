package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class serverMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 3222;

        ServerSocket serverSocket = new ServerSocket(port);

        while(true) {
            Socket clientSocket = serverSocket.accept();
            ServerWorker client = new ServerWorker(clientSocket);
            client.start();
        }
    }
}
