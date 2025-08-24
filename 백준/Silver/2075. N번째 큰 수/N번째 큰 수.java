import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < n * n; i++)
			pq.offer(read());
		int answer = 0;
		for (int i = 0; i < n; i++)
			answer = pq.poll();
		System.out.println(answer);

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
