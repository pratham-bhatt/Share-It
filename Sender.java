import java.io.*;
import java.net.*;

public class Sender {
    // Creating the socket
    public Socket createSocket(String host) {
        try 
        {
            Socket socket = new Socket(host, 1234);
            return socket;
        } 
        catch (Exception e) 
        {
            System.out.println("An Exception occured while creating the socket!!!");
            return null;
        }
    }

    // Code to send the file to the sender
    public void sendFiles(Socket s, String name)
    {
        try 
        {
            FileManagement f = new FileManagement();
            byte[] e1 = f.encode(name);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(name);
            dout.write(e1);
            dout.flush();
            dout.close();
            s.close();
        } 
        catch (IOException e) 
        {
            System.out.println("An Exception occur while sending the file!!!");
        }
    }
}
