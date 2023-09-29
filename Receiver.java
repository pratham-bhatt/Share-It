import java.io.*;
import java.net.*;

public class Receiver 
{
    // initalizing the server
    public void shareIPAdd()
    {
        try 
        {
            InetAddress myIP = InetAddress.getLocalHost();
            System.out.println("Ip address of the server is " + myIP.getHostAddress());
        } 
        catch (UnknownHostException e) 
        {
            System.out.println("An Exception occur while fetching IP Address.");
        }

    }
    public ServerSocket createServer()
    {
        try
        {
            ServerSocket ss = new ServerSocket(1234);
            return ss;
        }
        catch (Exception e)
        {
            System.out.println("An exception occur while creating the server");
            return null;
        }
    }

    //Connecting to client
    public Socket connectClient(ServerSocket ss)
    {
        try
        {
            Socket s = ss.accept();
            return s;
        }
        catch (Exception e)
        {
            System.out.println("An Exception occur while connecting to client");
            return null;
        }
    }

    // getting the input file 
    public void saveFile(Socket s, String dest)
    {
        try
        {
            FileManagement f = new FileManagement();

            DataInputStream din = new DataInputStream(s.getInputStream());

            String name = (String) din.readUTF();
            byte[] buffer = new byte[1024]; 
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int bytesRead;

            while ((bytesRead = din.read(buffer)) != -1) 
            {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            byte[] receivedData = byteArrayOutputStream.toByteArray();

            f.decode(receivedData,name,dest);
            System.out.println("Received data length: " + receivedData.length);

            // closing 
            din.close();
            s.close();
        }
        catch (Exception e)
        {
            System.out.println("An Exception occur while receiving or saving the file!!!");
        }
    }
}
