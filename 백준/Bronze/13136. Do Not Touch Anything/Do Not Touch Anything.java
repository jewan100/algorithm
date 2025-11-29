import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double R = Double.parseDouble(st.nextToken());
		double C = Double.parseDouble(st.nextToken());
		double N = Double.parseDouble(st.nextToken());
		
		//풀이방법에 적은 것처럼 int로는 안되기 때문에 long 사용
		//가로와 세로 값을 구해서 반올림
		long RCCTV = (long) Math.ceil(R / N);
		long CCCTV = (long) Math.ceil(C / N);
		
		//넓이
		long CCTV = RCCTV * CCCTV;
		
		System.out.println(CCTV);
	}

}