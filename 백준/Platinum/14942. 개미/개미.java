import java.util.ArrayList;

public class Main {

	static int n, LOG;
	static int[] arr;
	static int[][] p, d;
	static boolean[] v;
	static ArrayList<ArrayList<int[]>> g = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		n = read();
		LOG = (int) (Math.log(n) / Math.log(2)) + 1;
		arr = new int[n + 1];
		for (int i = 1; i < n + 1; i++)
			arr[i] = read();
		for (int i = 0; i < n + 1; i++)
			g.add(new ArrayList<>());
		for (int i = 0; i < n - 1; i++) {
			int a = read(), b = read(), c = read();
			g.get(a).add(new int[]{b, c});
			g.get(b).add(new int[]{a, c});
		}
		p = new int[n + 1][LOG];
		d = new int[n + 1][LOG];
		v = new boolean[n + 1];
		dfs(1, 0, 0);
		build();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++)
			sb.append(up(i, arr[i])).append("\n");
		System.out.println(sb);
	}

	static void dfs(int cur, int parent, int weight) {
		v[cur] = true;
		p[cur][0] = parent;
		d[cur][0] = weight;
		for (int[] nxt : g.get(cur))
			if (!v[nxt[0]])
				dfs(nxt[0], cur, nxt[1]);
	}

	private static void build() {
		for (int j = 1; j < LOG; j++)
			for (int i = 1; i < n + 1; i++) {
				int m = p[i][j - 1];
				if (m == 0)
					continue;
				p[i][j] = p[m][j - 1];
				d[i][j] = d[i][j - 1] + d[m][j - 1];
			}
	}

	private static int up(int i, int e) {
		for (int j = LOG - 1; j >= 0; j--) {
			int nxt = p[i][j];
			int weight = d[i][j];
			if (nxt != 0 && e >= weight) {
				e -= weight;
				i = nxt;
			}
		}
		return i;
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