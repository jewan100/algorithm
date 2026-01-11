public class Main {

	static final int DIFF = 10_000_000;

	public static void main(String[] args) throws Exception {
		int n = read();
		int[] arr = new int[(DIFF << 1) + 1];
		for (int i = 0; i < n; i++)
			arr[read() + DIFF]++;
		int m = read();
		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			sb.append(arr[read() + DIFF]).append(" ");
		}
		System.out.println(sb);
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