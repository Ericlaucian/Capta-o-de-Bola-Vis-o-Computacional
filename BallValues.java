import java.io.BufferedReader;
import java.io.IOException;

public class BallValues {
    
    PythonConnection pythonConnection;
    public String linha;

    public int[] coordenadas = new int[4];

    public BallValues(BufferedReader in) throws IOException {
        this.linha = getLinha(in);
    }
    
    public String getLinha(BufferedReader in) throws IOException {
        return in.readLine();
    }

    public int[] getCoordenadas() throws IOException {
        return java.util.Arrays.stream(this.linha.split(","))
                                .map(String::trim)
                                .mapToInt(Integer::parseInt)
                                .toArray();
    }
}
