import java.util.Arrays;

public class Main {

	static int n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		n = read();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		Arrays.sort(arr);
		int[] result = new int[2];
		int minDiff = 1_000_000_001 << 1;
		int l = 0, r = n - 1;
		while (l < r) {
			int sum = arr[l] + arr[r];
			int diff = Math.abs(sum);
			if (diff < minDiff) {
				minDiff = diff;
				result = new int[]{arr[l], arr[r]};
			}
			if (diff == 0)
				break;
			if (sum < 0)
				l++;
			else
				r--;
		}
		System.out.println(result[0] + " " + result[1]);
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return m ? ~n + 1 : n;
	}
}