public class Main {

	public static void main(String[] args) throws Exception {
		int k = read(), n = (1 << k) - 1;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			int start = (1 << (k - i - 1)) - 1;
			int step = (1 << (k - i));
			int cnt = (1 << i);
			for (int j = 0; j < cnt; j++) {
				int idx = start + j * step;
				sb.append(arr[idx]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
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