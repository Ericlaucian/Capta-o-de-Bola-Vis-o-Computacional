import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder("python", "detect.py");

        try{
            processBuilder.start();
            System.out.println("Processo Python iniciado com sucesso.");

            Thread.sleep(1500);

            String host = "127.0.0.1";
            int port = 5000;
            System.out.println("Conectando ao python...");
            try (Socket socket = new Socket(host, port); 
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                System.out.println("Conectado ao python");

                // Recebe a resposta do servidor
                float[] linha = new float[4];
                while (linha != null) {
                    System.out.println("Resposta do Python: " + linha[0]);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }
}