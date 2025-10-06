import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] isFriend = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++)
				isFriend[i][j] = line.charAt(j) == 'Y';
		}
		int maxCnt = 0;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			boolean[] arr = new boolean[n];
			for (int j = 0; j < n; j++) {
				if (isFriend[i][j]) {
					arr[j] = true;
					for (int k = 0; k < n; k++) {
						if (k == i)
							continue;
						if (isFriend[j][k])
							arr[k] = true;
					}
				}
			}
			for (int j = 0; j < n; j++)
				if (arr[j])
					cnt++;
			maxCnt = Math.max(cnt, maxCnt);
		}
		System.out.println(maxCnt);
	}
}