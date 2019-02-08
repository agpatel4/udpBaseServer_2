/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpbaseserver_2;
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException; 
import java.util.Scanner;

/**
 *
 * @author eddie
 */
public class UdpBaseServer_2 {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) throws IOException 
    { 
        
        DatagramSocket ds = new DatagramSocket(5100); 
        byte[] receive = new byte[65535]; 
        byte [] message = new byte[65535];
        DatagramPacket DpReceive = null; 
        DatagramPacket send = null;
        while (true) 
        { 
  
           
            
            DpReceive = new DatagramPacket(receive, receive.length); 
            System.out.println("Ready to Receive data "); 
            // Step 3 : revieve the data in byte buffer. 
            ds.receive(DpReceive); 
           // System.out.println("The packet was received");
            System.out.println("Android" + data(receive)); 
            
            System.out.println("Type your message");
            Scanner sc = new Scanner(System.in);
            String response = sc.nextLine();
            
            message = response.getBytes();
            InetAddress address = DpReceive.getAddress();
            int port = DpReceive.getPort();
            send = new DatagramPacket(message, message.length, address, port);
            ds.send(send);
            // Exit the server if the client sends "bye" 
            if (data(receive).toString().equals("bye")) 
            { 
                System.out.println("Client sent bye.....EXITING"); 
                break; 
            } 
  
            // Clear the buffer after every message. 
            receive = new byte[65535]; 
        } 
    } 
  
    // A utility method to convert the byte array 
    // data into a string representation. 
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    } 
    
}
