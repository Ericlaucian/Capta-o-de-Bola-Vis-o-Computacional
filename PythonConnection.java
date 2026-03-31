import java.io.*;
import java.net.*;

public class PythonConnection {

    ProcessBuilder processBuilder = new ProcessBuilder("python", "detect.py");
    String host = "127.0.0.1";
    int port = 5000;

    public void Connect() {
        try {
            processBuilder.start();
            System.out.println("Processo Python iniciado com sucesso.");
            Thread.sleep(2500);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() throws IOException {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Conectado ao python");
            return socket;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public BufferedReader getBufferedReader(Socket socket) throws IOException {
        try {
            return new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
