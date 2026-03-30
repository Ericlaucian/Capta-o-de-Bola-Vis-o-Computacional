import java.io.BufferedReader;
import java.io.IOException;

public class BallMethods {
   
    public static String getCoordenadasString(BufferedReader in) throws IOException {
       String linha;
       while ((linha = in.readLine()) != null) {
           return linha;
       }

       return null;
    }

    public static int[] makeCoordenadasInt(String coordenadasString) {
        return java.util.Arrays.stream(coordenadasString.split(","))
                                .map(String::trim)
                                .mapToInt(Integer::parseInt)
                                .toArray();
    }

}
