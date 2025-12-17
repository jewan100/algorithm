import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int count = 0;
			int N = Integer.parseInt(br.readLine());
			while(true) {
				if(N == 1) {
					System.out.println(count);
					break;
				}
				if(N % 2 == 1) {
					System.out.print(count + " ");
				}
				count++;
				N /= 2;
			}
		}
	}

}