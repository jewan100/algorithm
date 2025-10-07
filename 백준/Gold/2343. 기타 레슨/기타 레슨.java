public class Main {

	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		arr = new int[n];
		int l = 0, r = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = read();
			l = Math.max(l, arr[i]);
			r += arr[i];
		}
		while (l <= r) {
			int mid = (l + r) / 2;
			if (isPossible(mid))
				r = mid - 1;
			else
				l = mid + 1;
		}
		System.out.println(l);
	}

	private static boolean isPossible(int target) {
		int cnt = 1;
		int sumLen = 0;
		for (int len : arr) {
			if (sumLen + len <= target)
				sumLen += len;
			else {
				cnt++;
				sumLen = len;
			}
		}
		return cnt <= m;
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