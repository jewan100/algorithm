public class Main {

	public static void main(String[] args) throws Exception {
		int a = read(), b = read(), c = read(), d = read();
		int ac = a + c, bd = b + d;
		if (ac < bd)
			System.out.println("Hanyang Univ.");
		else if (ac > bd)
			System.out.println("Yongdap");
		else
			System.out.println("Either");
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