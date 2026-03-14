import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A = 0;
		int B = 1;
		
		for(int i = 2; i <= N; i++) {
			if(i % 2 == 0) {
				A += B;
			}else {
				B += A;
			}
		}
		if(N % 2 == 0) {
			System.out.println(A);
		}else {
			System.out.println(B);
		}
	}

}