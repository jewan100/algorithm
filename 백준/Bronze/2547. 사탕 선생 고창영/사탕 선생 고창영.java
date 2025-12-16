import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			BigInteger sum = new BigInteger("0");
			String S = br.readLine();
			BigInteger N = new BigInteger(br.readLine());
			
			for(int j = 0; j < N.intValue(); j++) {
				BigInteger M = new BigInteger(br.readLine());
				sum = sum.add(M);
			}
			String result = ((sum.remainder(N)).compareTo(BigInteger.ZERO) == 0) ? "YES" : "NO";
			
			System.out.println(result);
		}
	}

}