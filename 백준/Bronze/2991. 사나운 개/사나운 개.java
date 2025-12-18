import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 3; i++) {
			int N = Integer.parseInt(st.nextToken());
			int Fdog = N % (A + B);
			int Sdog = N % (C + D);
			int count = 0;
			
			if(Fdog <= A && Sdog <= C) {
				count = 2;
			}else if(Fdog <= A || Sdog <= C) {
				count = 1;
			}
			if(Fdog == 0) {
				count -= 1;
			}
			if(Sdog == 0) {
				count -= 1;
			}
			
			System.out.println(count);
		}
	}

}