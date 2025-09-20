import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        BigDecimal tentArea = new BigDecimal(br.readLine());

        double tentPerimeter = tentArea
                .multiply(BigDecimal.valueOf(Math.PI))
                .multiply(BigDecimal.valueOf(4))
                .sqrt(new MathContext(12)).doubleValue();

        System.out.println(tentPerimeter);
    }
}