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

        String linha;

        int ballId = 0;
        float confidence = 0.0f;
        int classId = 0;
        int[] coordenadas = new int[4];


        while (true) {
            
            linha = ballValues.getLinha(in);
            // ballValues.getAllValues(linha, ballId, coordenadas, confidence, classId);
            ballId = ballValues.getId(linha);
            
            // System.out.println(linha);
            System.out.println("ID: " + ballId);

            if (linha == null) {
                System.out.println("Conexão encerrada pelo Python.");
                break;
            }
        } 
    }


}