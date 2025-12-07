import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int sum = 0;
			int n = Integer.parseInt(br.readLine());
			for(int j = 1; j <= n; j++) {
				int A = 0;
				
				//T(K+1)을 반복문을 통해 구하고, A에 저장
				for(int k = 1; k <= (j + 1); k++) {
					A += k;
				}
				//W(n)을 구하는 식
				sum += (j * A);
			}
			System.out.println(sum);
		}
		
	}

}