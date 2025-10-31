public class Main {

	public static void main(String[] args) throws Exception {
		int h = read(), w = read();
		int[] arr = new int[w + 2];
		for (int i = 1; i < w + 1; i++)
			arr[i] = read();
		int[] brr = new int[w + 2], crr = new int[w + 2];
		for (int l = 1, r = w; l < w + 1; l++, r--) {
			brr[l] = Math.max(brr[l - 1], arr[l]);
			crr[r] = Math.max(crr[r + 1], arr[r]);
		}
		int sum = 0;
		for (int i = 1; i < w + 1; i++)
			sum += Math.min(brr[i], crr[i])- arr[i];
		System.out.println(sum);
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