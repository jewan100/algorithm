import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		int n = read();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(read()).append(" ");
			int answer = 0;
			TreeSet<Integer> tm = new TreeSet();
			for (int j = 0; j < 20; j++) {
				int num = read();
				answer += tm.tailSet(num).size();
				tm.add(num);
			}
			sb.append(answer).append("\n");
		}
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