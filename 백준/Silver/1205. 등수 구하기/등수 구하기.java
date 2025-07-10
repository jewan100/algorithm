import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), s = read(), p = read();
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++)
			al.add(read());
		int rank = 1;
		for (int i = 0; i < n; i++) {
			if (al.get(i) > s)
				rank++;
			else if (al.get(i) < s)
				break;
			p--;
		}
		if (p <= 0)
			rank = -1;
		System.out.println(rank);
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