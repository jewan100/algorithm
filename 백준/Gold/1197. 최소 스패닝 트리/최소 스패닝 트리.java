import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {

	static int v, e;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		v = read();
		e = read();
		parent = new int[v + 1];
		for (int i = 0; i < v + 1; i++)
			parent[i] = i;
		ArrayList<int[]> al = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			int a = read(), b = read(), c = read();
			al.add(new int[]{a, b, c});
		}
		long sum = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		pq.addAll(al);
		while (!pq.isEmpty()) {
			int[] edge = pq.poll();
			if (union(edge[0], edge[1]))
				sum += edge[2];
		}
		System.out.println(sum);
	}

	private static int find(int x) {
		if (parent[x] == x)
			return parent[x];
		return parent[x] = find(parent[x]);
	}

	private static boolean union(int y, int x) {
		int rootY = find(y), rootX = find(x);
		if (rootY == rootX)
			return false;
		parent[rootX] = rootY;
		return true;
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