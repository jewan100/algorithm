import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cArr = br.readLine().toCharArray();
		int z = 0, o = 0;
		for (char c : cArr)
			if (c == '0')
				z++;
			else
				o++;
		z >>= 1;
		o >>= 1;
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] == '1') {
				cArr[i] = '\0';
				o--;
				if (o == 0)
					break;
			}
		}
		for (int i = cArr.length - 1; i >= 0; i--) {
			if (cArr[i] == '0') {
				cArr[i] = '\0';
				z--;
				if (z == 0)
					break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : cArr)
			if (c != '\0')
				sb.append(c);
		System.out.println(sb);
	}
}
