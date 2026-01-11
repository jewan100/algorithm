import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		char[] cArr = br.readLine().toCharArray();
		int[] arr = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int l = 0, r = 0;
		for (; r < m; r++)
			arr[getIndex(cArr[r])]--;
		int cnt = isPossible(arr) ? 1 : 0;
		while (r < n) {
			arr[getIndex(cArr[l++])]++;
			arr[getIndex(cArr[r++])]--;
			if (isPossible(arr))
				cnt++;
		}
		System.out.println(cnt);
	}

	private static int getIndex(char c) {
		switch (c) {
			case 'A' :
				return 0;
			case 'C' :
				return 1;
			case 'G' :
				return 2;
			default :
				return 3;
		}
	}

	private static boolean isPossible(int[] arr) {
		for (int i : arr)
			if (i > 0)
				return false;
		return true;
	}
}