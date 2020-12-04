package sample;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ServerWorker extends Thread {

    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public ServerWorker(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        inputStream = clientSocket.getInputStream();
        outputStream = clientSocket.getOutputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            System.out.println("ashchi");
            handleClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient() throws IOException {
        Scanner ob2 = new Scanner(clientSocket.getInputStream());
        PrintStream ps = new PrintStream(clientSocket.getOutputStream());

        FindUser findUser = new FindUser();
        boolean verdict = false;

        while(true) {
            String message = "vaag", rec;
            rec = ob2.nextLine();

            System.out.println("login = " + rec);

            String[] tokens = rec.split(" ", 10);

            for(String a : tokens) {
                System.out.println("this = " + a + "x");
            }

            if(tokens.length == 3 && tokens[0] != null) {
                if(tokens[0].equalsIgnoreCase("login")) {
                    verdict = findUser.find(tokens[1], tokens[2]);
                }

                if(verdict)
                    message = "okay";
            }

            ps.println(message);
        }
    }
}
