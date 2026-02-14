import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		String[] word = new String[N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int typoNum = Integer.parseInt(st.nextToken());
			String typoWord = st.nextToken();
			word[i] = "";
			for(int j=0;j<typoWord.length();j++) {
			
				if(!(j == typoNum-1)) {
					word[i] = word[i]+typoWord.charAt(j);
					}		
			}
			if(i-1==N) {
				bw.write(word[i]+"");	
			}else {
				bw.write(word[i]+"\n");	
			}
		}
		bw.close();
		br.close();
	}
}