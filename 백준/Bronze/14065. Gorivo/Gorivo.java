import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final double GALON = 3.785411784;
    static final double MILE = 1.609344;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());

        System.out.println(100 / (MILE / GALON * n));
    }
}