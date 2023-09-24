import java.io.*;
import java.net.*;
import java.util.*;
class client
{
    public static void main(String [] args)
    {
        
        try 
        {
            Scanner scan = new Scanner(System.in);
            FileManagement f = new FileManagement();
            System.out.println("Enter the name of the file: ");
            String name = scan.nextLine();
            byte[] e1 = f.encode(name);
            Socket s = new Socket("localhost",1234);
            
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            dout.writeUTF(name);
            dout.write(e1);
            dout.flush();

            dout.close();
            s.close();
            scan.close();
        } 
        catch (Exception e) 
        {
            System.out.println("An Exception Occured!!!");
        }
    }
}