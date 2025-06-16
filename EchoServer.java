import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server started. Waiting for client...");
            Socket s = ss.accept();
            System.out.println("Client connected.");
            
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            
            String received = "";
            while (!received.equals("stop")) {
                received = din.readUTF();
                System.out.println("Client says: " + received);
                dout.writeUTF(received);  // Echo the same message
            }
            
            din.close();
            dout.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
