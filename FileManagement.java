import java.io.*;
import java.nio.file.*;
// import java.util.Arrays;

public class FileManagement
{
    public byte[] encode(String name) {
        byte[] enc = null;
        String path = System.getProperty("user.dir") + "\\"+name;
        try {
            enc = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println(e);
        }
        return enc;
    }
    
    public void decode(byte[] enc, String name, String dest)
    {
        String finalpath = System.getProperty("my.custom.path", dest) + "\\"+name;
        try 
        {
            // byte[] encoded = Files.readAllBytes(Paths.get(path));
            Files.write(Paths.get(finalpath),enc);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    // public static void main(String [] args)
    // {
    //     FileManagement f = new FileManagement();
    //     byte[] e;
    //     e=f.encode("abc.txt");
    //     f.decode(e);
    // }
}