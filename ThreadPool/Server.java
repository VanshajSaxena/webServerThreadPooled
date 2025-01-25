import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
  private final ExecutorService threadPool;

  public Server(int poolSize) {
    this.threadPool = Executors.newFixedThreadPool(poolSize);
  }

  public static void main(String[] args) {
    int port = 8010;
    int poolSize = 50;
    Server server = new Server(poolSize);
    try (ServerSocket serverSocket = new ServerSocket(port);) {
      serverSocket.setSoTimeout(20000);
      System.out.println("Server is listening on port: " + port);
      while (true) {
        Socket clientSocket = serverSocket.accept();
        server.threadPool.execute(() -> server.handleClient(clientSocket));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void handleClient(Socket clientSockt) {
    try (PrintWriter toSocket = new PrintWriter(clientSockt.getOutputStream(), true)) {
      toSocket.println("Hello from the server " + clientSockt.getInetAddress());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
