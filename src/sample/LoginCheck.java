package sample;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class LoginCheck {
    public boolean check(String id, String password) throws IOException {
        Scanner ob1 = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1",3222);
        Scanner ob2 = new Scanner(socket.getInputStream());
        PrintStream ps = new PrintStream(socket.getOutputStream());

        String login = "login " + id + " " + password;

        while(true) {
            String message, rec;

            message = login;

            ps.println(message);

            rec = ob2.nextLine();

            System.out.println("verdict = " + rec);
            if(rec.equalsIgnoreCase("okay")) {
                return true;
            }
            else if(rec != null) return false;
        }
    }
}
