import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] sArr = new String[n];
		for (int i = 0; i < n; i++)
			sArr[i] = br.readLine();

		int[] pArr = new int[27];
		for (String str : sArr) {
			for (int i = 0; i < str.length(); i++) {
				int c = str.charAt(i) - 'A';
				int idx = str.length() - i;
				pArr[c] += Math.pow(10, idx - 1);
			}
		}
		int[] arr = new int[27];
		for (int i = 9; i > 0; i--) {
			int idx = 26;
			boolean flag = false;
			for (int j = 0; j < 26; j++) {
				if (pArr[j] == 0)
					continue;
				if (pArr[j] > pArr[idx]) {
					idx = j;
					flag = true;
				}
			}
			if (!flag)
				break;
			pArr[idx] = 0;
			arr[idx] = i;
		}
		int sum = 0;
		for (String str : sArr) {
			int num = 0;
			for (int i = 0; i < str.length(); i++) {
				int c = str.charAt(i) - 'A';
				int idx = str.length() - i - 1;
				num += arr[c] * Math.pow(10, idx);
			}
			sum += num;
		}
		System.out.println(sum);
	}
}