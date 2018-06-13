
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Client {
    Socket s;
    DataInputStream din;
    DataOutputStream dout;
     
    public Client() {
        try{
            s=new Socket("localhost",100);
            System.out.println(s);
            din=new DataInputStream(s.getInputStream());
            dout=new DataOutputStream(s.getOutputStream());
            clientchat();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
     
    }

public void clientchat() throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String s1;
    do {
        s1=br.readLine();
        dout.writeUTF(s1);
        dout.flush();
        System.out.println("server message  "+din.readUTF());
        
    }
    while(!s1.equals("stop"));
}
public static void main(String args[])
{
    new Client();
}
}


