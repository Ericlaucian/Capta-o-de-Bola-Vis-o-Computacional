import java.io.BufferedReader;
import java.io.IOException;

public class BallValues {
    
    PythonConnection pythonConnection;
    public String linha;
    public int[] coordenadas = new int[4];
    public float confidence;
    public int classId;
    public int id;

    public BallValues(BufferedReader in) throws IOException {
        this.linha = getLinha(in);
    }
    
    public String getLinha(BufferedReader in) throws IOException {
        return in.readLine();
    }

    public int getId(String linha) throws IOException {
        return Integer.parseInt(linha.split(",")[0].trim());
    }

    public int[] getCoordenadas(String linha) throws IOException {
        String[] parts = linha.split(",");
        for (int i = 0; i < 4; i++) {
            coordenadas[i] = Integer.parseInt(parts[i + 1].trim());
        }
        return coordenadas;
    }

    public float getConfidence(String linha) throws IOException {
        return Float.parseFloat(linha.split(",")[5].trim());
    }

    public int getClassId(String linha) throws IOException {
        return Integer.parseInt(linha.split(",")[6].trim());
    }

    public void getAllValues(String linha, int id, int[] coordenadas, float confidence, int classId) throws IOException {
        id = getId(linha);
        coordenadas = getCoordenadas(linha);
        confidence = getConfidence(linha);
        classId = getClassId(linha);
    }

}
