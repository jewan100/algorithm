import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] cArr = br.readLine().toCharArray();
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (cArr[i] == 'P') {
				for (int j = i - k; j <= i + k; j++)
					if (isValid(j) && cArr[j] == 'H') {
						cArr[i] = 'X';
						cArr[j] = 'X';
						cnt++;
						break;
					}
			}
		}
		System.out.println(cnt);
	}

	private static boolean isValid(int p) {
		return 0 <= p && p < n;
	}
}