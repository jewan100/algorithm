import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int len = str.length();
		int[] cArr = new int[26];
		for (int i = 0; i < len; i++)
			cArr[str.charAt(i) - 'A']++;
		int cnt = 0;
		loop : for (int i = 1; i < n; i++) {
			str = br.readLine();
			int lenDiff = Math.abs(len - str.length());
			if (lenDiff > 1)
				continue;
			int[] charDiff = new int[26];
			for (int j = 0; j < str.length(); j++)
				charDiff[str.charAt(j) - 'A']++;
			int diffSum = 0;
			for (int j = 0; j < 26; j++) {
				charDiff[j] = Math.abs(charDiff[j] - cArr[j]);
				if (charDiff[j] > 1)
					continue loop;
				diffSum += charDiff[j];
			}
			if (diffSum <= 2)
				cnt++;
		}
		System.out.println(cnt);
	}
}