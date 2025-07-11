public class Main {

	static int n, m;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		arr = new int[n];
		for (int i = 0; i < m; i++)
			arr[i] = read();
		int l = 0, r = n;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (isPossible(mid))
				r = mid - 1;
			else
				l = mid + 1;
		}
		System.out.println(l);
	}

	private static boolean isPossible(int t) {
		int s = 0;
		for (int i = 0; i < m; i++) {
			if (arr[i] - t <= s)
				s = arr[i] + t;
			else
				return false;
		}
		return s >= n;
	}

	public static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return n;
	}
}