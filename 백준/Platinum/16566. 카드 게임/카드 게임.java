import java.util.Arrays;

public class Main {

	static int n, m, k;
	static int[] arr, parent;

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		k = read();
		arr = new int[m];
		parent = new int[m + 1];
		for (int i = 0; i < m; i++) {
			arr[i] = read();
			parent[i] = i;
		}
		parent[m] = m;
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			int idx = find(binarySearch(read()));
			sb.append(arr[idx]).append("\n");
			union(idx, idx + 1);
		}
		System.out.println(sb);
	}

	private static int find(int x) {
		if (parent[x] == x)
			return parent[x];
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		int rootX = find(x), rootY = find(y);
		if (rootX > rootY)
			parent[rootY] = rootX;
		else
			parent[rootX] = rootY;
	}

	private static int binarySearch(int num) {
		int l = 0, r = m - 1;
		while (l <= r) {
			int m = (l + r) >> 1;
			if (num >= arr[m])
				l = m + 1;
			else
				r = m - 1;
		}
		return l;
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