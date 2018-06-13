
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
     
    public Server() {
        try{
            System.out.println("SERVER STARTED");
            ss=new ServerSocket(100);
            s=ss.accept();
            System.out.println(s);
            System.out.println("CLIENT CONNECTED");
            dis=new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());
            serverchat();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     
    }
public static void main(String args[]) {
     new Server();
}
public void serverchat() throws IOException {
    String str;
    do {
        str=dis.readUTF();
        System.out.println("client message "+str);
        dos.writeUTF("hello  "+ str);
        dos.flush();
        
    }
    while(!str.equals("stop"));
}
}
