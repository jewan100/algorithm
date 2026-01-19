import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		String S = "";
		while((input = br.readLine()) != null) {
			S += input;
		}
		int max = 0;
		String Smax = "";
		for(char i = 97; i < 123; i++) {
			int count = S.length() - S.replace(String.valueOf(i), "").length();
			if(max == count) {
				Smax += String.valueOf(i);
			}
			if(max < count) {
				max = count;
				Smax = String.valueOf(i);
			}
		}
		System.out.println(Smax);
	}

}