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
			int target = (l + r) >> 1;
			if (isPossible(target))
				r = target - 1;
			else
				l = target + 1;
		}
		System.out.println(l);
	}

	private static boolean isPossible(int target) {
		int money = 0, cnt = 0;
		for (int i = 0; i < n; i++) {
			if (money < arr[i]) {
				cnt++;
				money = target;
			}
			money -= arr[i];
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