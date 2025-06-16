import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient {
    public static void main(String args[]) {
        try {
            Socket s = new Socket("localhost", 6666);
            
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner input = new Scanner(System.in);
            
            String send = "";
            while (!send.equals("stop")) {
                System.out.print("To Server: ");
                send = input.nextLine();
                dout.writeUTF(send);
                String reply = din.readUTF();
                System.out.println("Server echoed: " + reply);
            }
            
            din.close();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
