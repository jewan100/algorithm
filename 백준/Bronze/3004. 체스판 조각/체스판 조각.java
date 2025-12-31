import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 2;
		
		for(int i = 2; i <= N; i++) {
			sum += ((i / 2) + 1);
		}
		System.out.println(sum);
	}

}