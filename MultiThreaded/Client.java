import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    Client client = new Client();
    for (int i = 0; i < 100; i++) {
      try {
        Thread thread = new Thread(client.getRunnable());
        thread.start();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  private Runnable getRunnable() {
    return () -> {
      int port = 8010;
      try {
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);
        PrintWriter toServer = new PrintWriter(socket.getOutputStream());
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toServer.println("Hello from the client." + socket.getLocalSocketAddress());
        toServer.flush();
        String line = fromServer.readLine();
        System.out.println("Response from the server: " + line);
        socket.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    };
  }
}
