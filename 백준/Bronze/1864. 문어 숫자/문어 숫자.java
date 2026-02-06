import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String S = br.readLine();
			int result = 0;
			int n = S.length();
			if(S.equals("#")) {
				break;
            }
			for(int i = 0; i < n; i++) {
				if(S.charAt(i) == '-') {
					result += 0 * Math.pow(8, ((n - 1) - i));
				}else if(S.charAt(i) == '\\') {
					result += 1 * Math.pow(8, ((n - 1) - i));
				}else if(S.charAt(i) == '(') {
					result += 2 * Math.pow(8, ((n - 1) - i));
				}else if(S.charAt(i) == '@') {
					result += 3 * Math.pow(8, ((n - 1) - i));
				}else if(S.charAt(i) == '?') {
					result += 4 * Math.pow(8, ((n - 1) - i));
				}else if(S.charAt(i) == '>') {
					result += 5 * Math.pow(8, ((n - 1) - i));
				}else if(S.charAt(i) == '&') {
					result += 6 * Math.pow(8, ((n - 1) - i));
				}else if(S.charAt(i) == '%') {
					result += 7 * Math.pow(8, ((n - 1) - i));
				}else {
					result += -1 * Math.pow(8, ((n - 1) - i));
				}
			}
			System.out.println(result);
		}
	}
}