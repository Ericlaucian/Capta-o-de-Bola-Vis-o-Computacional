// import java.io.*;
// import java.net.*;
// import java.util.Arrays;

// public class Main {
//     public static int[] coordenadas = new int[4];
//     static int[] media = new int[2];
//     public static void main(String[] args) throws InterruptedException {

//         ProcessBuilder processBuilder = new ProcessBuilder("python", "detect.py");

//         try{
//             processBuilder.start();
//             System.out.println("Processo Python iniciado com sucesso.");

//             Thread.sleep(2500);

//             String host = "127.0.0.1";
//             int port = 5000;
//             System.out.println("Conectando ao python...");
//             try (Socket socket = new Socket(host, port); 
//             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

//                 System.out.println("Conectado ao python");

//                 // Recebe a resposta do servidor
//                 String linha;
//                 while ((linha = in.readLine()) != null) {
//                     coordenadas = Arrays.stream(linha.split(","))
//                                         .map(String::trim)
//                                         .mapToInt(Integer::parseInt)
//                                         .toArray();
//                     media[0] = mediaX(coordenadas[0], coordenadas[2]);
//                     media[1] = mediaY(coordenadas[1], coordenadas[3]);
//                 }
            
                

//             } catch (IOException e) {
//                 e.printStackTrace();
//             }


//         } catch (IOException e) {
//             e.printStackTrace();
//         }

        
//     }

//     private static int mediaX(int x1, int x2){
//         return (x1 + x2) / 2;
//     }
//     private static int mediaY(int y1, int y2){
//         return (y1 + y2) / 2;
//     }
// }

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class Main{
    public static void main(String[] args) throws IOException {
        PythonConnection pythonConnection = new PythonConnection(); 
        pythonConnection.Connect();
        Socket socket = pythonConnection.getSocket();
        BufferedReader in = pythonConnection.getBufferedReader(socket);
        BallValues ballValues = new BallValues(in);
        while (true) {
            String linha = ballValues.getLinha(in);
            System.out.println("Linha: " + linha);
            if (linha == null){
                System.exit(0);
            }
        } 
    }


}