public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), x = read(), m = 0, c = 0, l = 1;
		int[] arr = new int[n];
		for (int i = 0; i < x; i++) {
			arr[i] = read();
			c += arr[i];
		}
		m = c;
		for (int i = x; i < n; i++) {
			arr[i] = read();
			c -= arr[i - x];
			c += arr[i];
			if (c > m) {
				m = c;
				l = 1;
			} else if (c == m)
				l++;
		}
		if (m == 0)
			System.out.println("SAD");
		else {
			System.out.println(m);
			System.out.println(l);
		}
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
