package linkserver;
import java.net.*;
import java.io.*;
public class client {
	 public static void main(String [] args)
	   {
	      String serverName = "192.168.2.101";
	      int port = 5736;
	      try
	      {
	         System.out.println("\nCli to " + serverName+ " on port " + port);
	         Socket client = new Socket(serverName, port);
	         System.out.println("\nCli connected to "+ client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF("\nCli:Ser from "+ client.getLocalSocketAddress());
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in =new DataInputStream(inFromServer);
	         System.out.println("\nServer says: " + in.readUTF());
	         client.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	   }
}
