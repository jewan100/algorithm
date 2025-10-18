import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read();
		PriorityQueue<Integer> pqA = new PriorityQueue<>();
		PriorityQueue<Integer> pqB = new PriorityQueue<>((o1, o2) -> (o2 - o1));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int p = read();
			if (pqA.size() >= pqB.size())
				pqB.add(p);
			else
				pqA.add(p);

			if (!pqA.isEmpty() && !pqB.isEmpty())
				if (pqA.peek() < pqB.peek()) {
					pqA.offer(pqB.poll());
					pqB.offer(pqA.poll());
				}

			sb.append(pqB.peek()).append("\n");
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