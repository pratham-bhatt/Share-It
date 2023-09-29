// import java.io.*;
import java.net.*;
import java.util.*;

public class ReceiverDriver 
{
    Scanner scan = new Scanner(System.in);

    Receiver rec = new Receiver();

    public void call() throws Exception
    {
        // for creating the server 
        ServerSocket ss = rec.createServer();
        System.out.println("The Server has Started.");
        System.out.println("The Server is waiting for client....");

        // for sharing the ip address
        rec.shareIPAdd();

        // for connecting the port 
        Socket s = rec.connectClient(ss);
        System.out.println("The client is CONNECTED");

        System.out.println("Enter the path you want to save the file");
        String dest = scan.nextLine();

        if(dest == null)
        {
            rec.saveFile(s, System.getProperty("user.dir"));
        }
        else
        {
            rec.saveFile(s, dest);
        }

        // for closing the sockets

        ss.close();
        s.close();

    }
}
