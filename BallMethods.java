
public class BallMethods {

    public int mediax(int[] coordenadas) {
        return (coordenadas[0] + coordenadas[2]) / 2;
    }

    public int mediay(int[] coordenadas) {
        return (coordenadas[1] + coordenadas[3]) / 2;
    }

    public int[] getCenter(int[] coordenadas) {
        return new int[]{mediax(coordenadas), mediay(coordenadas)};
    }

}
