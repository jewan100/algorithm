import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read();
		if (n == 0) {
			System.out.println(0);
			return;
		} else if (n == 1) {
			System.out.println(1);
			return;
		}
		BigInteger[] biArr = new BigInteger[3];
		biArr[0] = BigInteger.ZERO;
		biArr[1] = BigInteger.ONE;
		biArr[2] = BigInteger.ONE;
		for (int i = 3; i <= n; i++) {
			biArr[0] = biArr[1];
			biArr[1] = biArr[2];
			biArr[2] = biArr[0].add(biArr[1]);
		}
		System.out.println(biArr[2]);
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