import java.util.HashMap;

public class Main {

	static class Line {
		Node a;
		Node b;
		Line(Node a, Node b) {
			this.a = a;
			this.b = b;
		}
	}

	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] parent;
	static Line[] lines;

	public static void main(String[] args) throws Exception {
		int n = read();
		parent = new int[n];
		lines = new Line[n];
		for (int i = 0; i < n; i++) {
			int x1 = read(), y1 = read(), x2 = read(), y2 = read();
			Node a = new Node(x1, y1);
			Node b = new Node(x2, y2);
			lines[i] = new Line(a, b);
			parent[i] = i;
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = 1; j < n; j++) {
				int rootX = find(i), rootY = find(j);
				if (rootX == rootY)
					continue;
				Line l1 = lines[i], l2 = lines[j];
				int AB = ccw(l1.a, l1.b, l2.a) * ccw(l1.a, l1.b, l2.b);
				int CD = ccw(l2.a, l2.b, l1.a) * ccw(l2.a, l2.b, l1.b);
				if (AB <= 0 && CD <= 0) {
					if (AB == 0 && CD == 0) {
						int x1 = Math.max(l1.a.x, l1.b.x), x2 = Math.min(l1.a.x, l1.b.x);
						int x3 = Math.max(l2.a.x, l2.b.x), x4 = Math.min(l2.a.x, l2.b.x);
						int y1 = Math.max(l1.a.y, l1.b.y), y2 = Math.min(l1.a.y, l1.b.y);
						int y3 = Math.max(l2.a.y, l2.b.y), y4 = Math.min(l2.a.y, l2.b.y);
						if (x1 >= x4 && x3 >= x2 && y1 >= y4 && y3 >= y2)
							parent[rootY] = rootX;
					} else
						parent[rootY] = rootX;
				}
			}
		}
		HashMap<Integer, Integer> hm = new HashMap<>();
		int maxCnt = 0;
		for (int i = 0; i < n; i++) {
			int root = find(i);
			hm.put(root, hm.getOrDefault(root, 0) + 1);
			maxCnt = Math.max(maxCnt, hm.get(root));
		}
		System.out.println(hm.size() + "\n" + maxCnt);
	}

	private static int find(int x) {
		if (parent[x] == x)
			return parent[x];
		return parent[x] = find(parent[x]);
	}

	private static int ccw(Node a, Node b, Node c) {
		int r = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		if (r > 0)
			return 1;
		else if (r < 0)
			return -1;
		return 0;
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
