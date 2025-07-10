public class Main {

	static int n;

	public static void main(String[] args) throws Exception {
		n = read();
		boolean[] arr = new boolean[n];
		for (int i = 0; i < n; i++)
			if (read() == 1)
				arr[i] = true;
		int m = read();
		for (int i = 0; i < m; i++) {
			int s = read(), p = read(), idx = p - 1;
			arr[idx] = !arr[idx];
			if (s == 1) {
				while (idx + p < n) {
					idx += p;
					arr[idx] = !arr[idx];
				}
			} else {
				int l = idx - 1, r = idx + 1;
				while (isValid(l, r) && arr[l] == arr[r]) {
					arr[l] = !arr[l--];
					arr[r] = !arr[r++];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i] ? 1 : 0).append(" ");
			if ((i + 1) % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isValid(int l, int r) {
		return 0 <= l && l < n && 0 <= r && r < n;
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