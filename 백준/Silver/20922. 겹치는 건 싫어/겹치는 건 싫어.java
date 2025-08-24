public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), k = read(), l = 0, maxLen = 0;
		if (n <= k) {
			System.out.println(n);
			return;
		}
		int[] arr = new int[n], num = new int[100_001];
		for (int r = 0; r < n; r++) {
			arr[r] = read();
			num[arr[r]]++;
			while (num[arr[r]] > k)
				num[arr[l++]]--;
			maxLen = Math.max(maxLen, r - l + 1);
		}
		System.out.println(maxLen);
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return n;
	}
}
