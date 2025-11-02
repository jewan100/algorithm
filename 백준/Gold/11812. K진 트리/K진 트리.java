public class Main {

	public static void main(String[] args) throws Exception {
		long n = read(), k = read(), q = read();
		StringBuilder sb = new StringBuilder();
		for (long i = 0; i < q; i++) {
			long a = read(), b = read();
			if (k == 1)
				sb.append(Math.abs(a - b));
			else {
				int dist = 0;
				while (a != b) {
					if (a > b)
						a = (a - 2) / k + 1;
					else
						b = (b - 2) / k + 1;
					dist++;
				}
				sb.append(dist);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static long read() throws Exception {
		long c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return n;
	}
}