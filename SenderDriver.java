import java.util.*;
import java.io.*;
import java.net.*;

public class SenderDriver 
{
    Scanner s = new Scanner(System.in);

    Sender send = new Sender();
    
    public void call() throws IOException
    {
        // For getting the ipaddress of the receiver
        System.out.println("Enter the IPAddress of the Receiver");
        String ipadd = s.nextLine();

        //creating the socket    
        Socket socket = send.createSocket(ipadd);

        // For taking the file name 
        System.out.println("Enter the name of the file");
        String name = s.nextLine();

        // for sending the files 
        send.sendFiles(socket, name);

        // closing socket
        socket.close();

    }
}
