import java.util.ArrayList;

public class Main {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		int n = read(), m = read();
		for (int i = 0; i < n; i++)
			graph.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			int a = read(), b = read();
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			if (dfs(1, i)) {
				System.out.println(1);
				return;
			}
			visited[i] = false;
		}
		System.out.println(0);
	}

	private static boolean dfs(int depth, int p) {
		if (depth == 5)
			return true;
		for (int i : graph.get(p))
			if (!visited[i]) {
				visited[i] = true;
				if (dfs(depth + 1, i))
					return true;
				visited[i] = false;
			}
		return false;
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