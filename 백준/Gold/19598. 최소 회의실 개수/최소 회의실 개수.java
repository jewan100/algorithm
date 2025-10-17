import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read();
		int[][] info = new int[n][2];
		for (int i = 0; i < n; i++)
			info[i] = new int[]{read(), read()};
		Arrays.sort(info, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(info[0][1]);
		for (int i = 1; i < n; i++) {
			if (!pq.isEmpty() && pq.peek() <= info[i][0])
				pq.poll();
			pq.offer(info[i][1]);
		}
		System.out.println(pq.size());
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