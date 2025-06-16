import java.io.*;
import java.net.*;

public class FTPClient {
    public static void main(String[] args) throws Exception {
        InetAddress ia = InetAddress.getLocalHost();
        Socket s = new Socket(ia, 1024);

        System.out.print("Enter a new File Name to save received data: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fname = br.readLine();

        File f1 = new File(fname);
        PrintWriter pw = new PrintWriter(new FileWriter(f1));
        BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String str;
        while ((str = br1.readLine()) != null) {
            pw.println(str);
        }

        pw.close();
        br1.close();
        br.close();
        s.close();

        System.out.println("File received and saved as: " + fname);
    }
}