import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int aCnt = 0;
		char[] cArr = new char[len * 2];
		for (int i = 0; i < len; i++) {
			cArr[i] = cArr[i + len] = str.charAt(i);
			if (cArr[i] == 'a')
				aCnt++;
		}
		int[] cnt = new int[2];
		for (int i = 0; i < aCnt; i++)
			if (cArr[i] == 'a')
				cnt[0]++;
			else
				cnt[1]++;
		int minCnt = cnt[1];
		for (int i = 0; i < len; i++) {
			if (cArr[i] == 'a')
				cnt[0]--;
			else 
				cnt[1]--;
			if (cArr[i + aCnt] == 'a') 
				cnt[0]++;
			else
				cnt[1]++;
			minCnt = Math.min(minCnt, cnt[1]);
		}
		System.out.println(minCnt);
	}
}
