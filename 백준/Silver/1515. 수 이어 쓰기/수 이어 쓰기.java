import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cArr = br.readLine().toCharArray();
		int n = 1, i = 0, t, d, p;
		while (i < cArr.length) {
			t = n++;
			d = (int) Math.log10(t);
			p = (int) Math.pow(10, d);
			while (p > 0) {
				if (cArr[i] - '0' == t / p) {
					i++;
					if (i == cArr.length)
						break;
				}
				t %= p;
				p /= 10;
			}
		}
		System.out.println(n - 1);
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