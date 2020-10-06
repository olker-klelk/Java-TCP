package linkserver;
import java.net.*;
import java.io.*;

public class SERVER extends Thread{
private ServerSocket serverSocket;   
 public SERVER(int port) throws IOException
	   {
	      serverSocket = new ServerSocket(port);
	      serverSocket.setSoTimeout(10000);
	   }

	   public void run()
	   {
	      while(true)
	      {
	         try
	         {
	            System.out.println("\nSER: " +serverSocket.getLocalPort() + "...");
	            Socket server1 = serverSocket.accept();
	            System.out.println("\nSER connected to "+ server1.getRemoteSocketAddress());//192.168.2.101:50913
	            DataInputStream in = new DataInputStream(server1.getInputStream());
	            System.out.println("\n"+in.readUTF());
	            DataOutputStream out = new DataOutputStream(server1.getOutputStream());
	            out.writeUTF("\nSER connecting to " + server1.getLocalSocketAddress() + "Goodbye!");
	            server1.close();
	         }catch(SocketTimeoutException s)
	         {
	            System.out.println("\nSocket timed out!");
	            break;
	         }catch(IOException e)
	         {
	            e.printStackTrace();
	            break;
	         }
	      }
	   }
	   public static void main(String[] args)
	   {
	      int port = 5736;
	      try
	      {
	         Thread t = new SERVER(port);
	         t.start();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	   }
	}

