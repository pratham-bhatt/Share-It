import java.util.Scanner;
public class MainDriver 
{
    public static void main(String [] args) throws Exception
    {
        SenderDriver sd = new SenderDriver();
        ReceiverDriver rd = new ReceiverDriver();
        try (Scanner s = new Scanner(System.in)) {
            while(true)
            {
                System.out.println("Welcome to File Sharer App");
                System.out.println("Please seleect the below option");
                System.out.println("0: For Quit\n1: For Sending File\n2: For Receiving the File");
                int c = s.nextInt();
                if(c == 0)
                {
                    System.out.println("Thankyou for using this application");
                    break;
                }
                switch (c) 
                {
                    case 0:
                        break;
                    case 1:
                        sd.call();
                        break;
                    case 2:
                        rd.call();
                
                    default:
                        System.out.println("Such case doesn't exists!");
                        break;
                }

            }
        }
    }
}
