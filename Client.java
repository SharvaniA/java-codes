// Client program to send and receive messages from python server. 

import java.io.*;  
import java.net.*; 
public class Client 
{
    public static void main(String[] args) 
    {  
        try
        {      
            while (true)
            {
                Socket soc=new Socket("localhost",12346);  
                DataOutputStream dout=new DataOutputStream(soc.getOutputStream());  
                DataInputStream in = new DataInputStream(soc.getInputStream());
                String msg=(String)in.readUTF();
                System.out.println(""+ msg);

                InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader reader = new BufferedReader(isr);
                System.out.println("To Server:");
                String sendToServer = reader.readLine();

                dout.writeUTF(sendToServer);

                String msgfromServer=(String)in.readUTF();
                System.out.println("From Server: "+ msgfromServer);
                // dout.flush();
                // dout.close();
                // soc.close();
            }
        }
        catch(Exception e)
        {
          e.printStackTrace(); 
        }
    }
}





























// // Client in java
// // Connection between python server and java client.

// import java.io.*;  
// import java.net.*; 
// public class Client 
// {
//     public static void main(String[] args) 
//     {  
//         try
//         {      
//             Socket soc=new Socket("localhost",1234);  
//             DataOutputStream dout=new DataOutputStream(soc.getOutputStream());  
//             DataInputStream in = new DataInputStream(soc.getInputStream());
//             String msg=(String)in.readUTF();
//             System.out.println("Server: "+msg);
//             dout.writeUTF("Ok Boss");
//             dout.flush();
//             dout.close();
//             soc.close();
//         }
//         catch(Exception e)
//         {
//           e.printStackTrace(); 
//         }
//     }
// }





























// // A Java program for a Client
// import java.net.*;
// import java.io.*;
// import java.util.*;

// public class Client
// {
//     // initialize socket and input output streams
//     private Socket socket            = null;
//     private DataInputStream  input   = null;
//     private DataOutputStream out     = null;
 
//     // constructor to put ip address and port
//     public Client(String address, int port)
//     {
//         // establish a connection
//         try
//         {
//             socket = new Socket(address, port);
//             System.out.println("Connected");
 
//             // takes input from terminal
//             input  = new DataInputStream(System.in);
 
//             // sends output to the socket
//             out   = new DataOutputStream(socket.getOutputStream());
//         }
//         catch(UnknownHostException u)
//         {
//             System.out.println(u);
//         }
//         catch(IOException i)
//         {
//             System.out.println(i);
//         }
 
//         // string to read message from input
//         String line = "";
//          while ((line = br.readLine()) != null) 
//          {
//              System.out.println(line);
//          }
//         // keep reading until "Over" is input
//         while (!line.equals("Over"))
//         {
//             try
//             {
//                 line = input.readLine();
//                 out.writeUTF(line);
//             }
//             catch(IOException i)
//             {
//                 System.out.println(i);
//             }
//         }
 
//         // close the connection
//         try
//         {
//             input.close();
//             out.close();
//             socket.close();
//         }
//         catch(IOException i)
//         {
//             System.out.println(i);
//         }
//     }
 
//     public static void main(String args[])
//     {
//         Client client = new Client("192.168.0.104", 55555);
//     }
// }