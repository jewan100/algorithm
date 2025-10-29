import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {

	static ArrayList<ArrayList<Integer>> g = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> r = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> s = new ArrayList<>();
	static Deque<Integer> dq = new ArrayDeque<>();
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		for (int i = 0; i < n + 1; i++) {
			g.add(new ArrayList<>());
			r.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int a = read(), b = read();
			g.get(a).add(b);
			r.get(b).add(a);
		}
		v = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++)
			if (!v[i])
				dfs(i);
		v = new boolean[n + 1];
		while (!dq.isEmpty()) {
			int cur = dq.pollLast();
			if (!v[cur]) {
				if (s.size() >= 1) {
					System.out.println("No");
					return;
				}
				s.add(new ArrayList<>());
				reDfs(cur, s.size() - 1);
			}
		}
		System.out.println("Yes");
	}

	private static void dfs(int cur) {
		v[cur] = true;
		for (int next : g.get(cur))
			if (!v[next])
				dfs(next);
		dq.offerLast(cur);
	}

	private static void reDfs(int cur, int num) {
		v[cur] = true;
		for (int next : r.get(cur))
			if (!v[next])
				reDfs(next, num);
		s.get(num).add(cur);
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