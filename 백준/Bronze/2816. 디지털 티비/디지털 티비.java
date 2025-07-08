import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String chStr = "";
		int ch1 = 0, ch2 = 0;
		for (int i = 0; i < n; i++) {
			chStr = br.readLine();
			if (chStr.equals("KBS1"))
				ch1 = i;
			if (chStr.equals("KBS2"))
				ch2 = i;
		}
		if (ch2 < ch1)
			ch2++;
		sb.append("1".repeat(ch1)).append("4".repeat(ch1)).append("1".repeat(ch2)).append("4".repeat(ch2 - 1));
		System.out.println(sb);
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