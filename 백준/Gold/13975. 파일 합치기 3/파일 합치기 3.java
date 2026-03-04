import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		int t = read();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int k = read();
			PriorityQueue<Long> pq = new PriorityQueue<>();
			for (int i = 0; i < k; i++)
				pq.offer((long) read());
			long sum = 0;
			while (!pq.isEmpty()) {
				if (pq.size() == 1) {
					break;
				}
				long a = pq.poll(), b = pq.poll();
				sum += a + b;
				pq.offer(a + b);
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
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