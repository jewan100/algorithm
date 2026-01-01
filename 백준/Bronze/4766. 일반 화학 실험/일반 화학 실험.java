import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double N = Double.parseDouble(br.readLine());
		
		while(true) {
			double N2 = Double.parseDouble(br.readLine());
			if(N2 == 999) {
				break;
			}
			System.out.println(String.format("%.2f", (N2 - N)));
			N = N2;
		}
	}

}