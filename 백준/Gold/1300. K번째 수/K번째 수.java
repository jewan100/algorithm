public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), k = read();
		int l = 1, r = k;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (isPossible(mid, n, k))
				r = mid - 1;
			else
				l = mid + 1;
		}
		System.out.println(l);
	}

	private static boolean isPossible(int target, int n, int k) {
		long cnt = 0;
		for (int i = 1; i <= n; i++)
			cnt += Math.min(target / i, n);
		return cnt >= k;
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