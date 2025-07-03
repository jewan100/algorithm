import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
		private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());
	        int K = Integer.parseInt(st.nextToken());
	        
	        bw.write(String.valueOf((K / M)+" "+(K - (M * (K / M)))));
	        bw.flush();
	        bw.close();
	        
	    }
}