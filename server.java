import java.io.*;
import java.net.*;
import java.util.*;

public class server 
{
    public static void main(String [] args)
    {
        try 
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("Give the destination to save the file: ");
            String dest = scan.nextLine();
            FileManagement f = new FileManagement();
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            System.out.println("CONNECTION ESTABLISHED");
            DataInputStream din = new DataInputStream(s.getInputStream());

            String name = (String) din.readUTF();
            byte[] buffer = new byte[1024]; 
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int bytesRead;

            while ((bytesRead = din.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            byte[] receivedData = byteArrayOutputStream.toByteArray();
            f.decode(receivedData,name,dest);
            System.out.println("Received data length: " + receivedData.length);

            // System.out.println(sn);
            scan.close();
            din.close();
            ss.close();
            s.close();
        } 
        catch (Exception e) 
        {
            System.out.println("An Exception Occured!!!");
        }
    }
}
