import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			char[] cArr = br.readLine().toCharArray();
			int[] arr = new int[26];
			int k = Integer.parseInt(br.readLine()), len = cArr.length, l = 0, r = 0, rIdx, lIdx;
			int minLen = Integer.MAX_VALUE, maxLen = 0;
			while (r < len) {
				rIdx = cArr[r] - 'a';
				lIdx = cArr[l] - 'a';
				arr[rIdx]++;
				if (cArr[l] == cArr[r] && arr[rIdx] == k) {
					maxLen = Math.max(maxLen, r - l + 1);
					minLen = Math.min(minLen, r - l + 1);
				}
				while (l < r && arr[rIdx] >= k) {
					lIdx = cArr[l] - 'a';
					if (arr[rIdx] == k)
						minLen = Math.min(minLen, r - l + 1);
					arr[lIdx]--;
					l++;
				}
				while (0 < l && arr[rIdx] < k) {
					l--;
					lIdx = cArr[l] - 'a';
					arr[lIdx]++;
					if (cArr[l] == cArr[r] && arr[rIdx] == k)
						maxLen = Math.max(maxLen, r - l + 1);
				}
				r++;
			}
			if (minLen != Integer.MAX_VALUE)
				sb.append(minLen).append(" ").append(maxLen);
			else
				sb.append(-1);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
