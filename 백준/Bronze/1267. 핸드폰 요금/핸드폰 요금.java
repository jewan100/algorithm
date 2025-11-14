import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ym = 0;
		int mm = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int M = Integer.parseInt(st.nextToken());
			if((M % 30) >= 0) {
				ym += ((M / 30) + 1) * 10;
			}else {
				ym += (M / 30) * 10;
			}
			if((M % 60) >= 0) {
				mm += ((M / 60) + 1) * 15;
			}else {
				mm += (M / 60) * 15;
			}
		}
		if(ym < mm) {
			System.out.println("Y " + ym);
		}else if(mm < ym) {
			System.out.println("M " + mm);
		}else {
			System.out.println("Y M " + ym);
		}
	}

}