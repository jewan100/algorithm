import java.util.ArrayList;

public class Main {

	static ArrayList<ArrayList<Integer>> graph;
	static int m;

	public static void main(String[] args) throws Exception {
		int n = read();
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++)
			graph.add(new ArrayList<>());
		int root = -1;
		for (int i = 0; i < n; i++) {
			int parent = read();
			if (parent == -1)
				root = i;
			else
				graph.get(parent).add(i);
		}
		m = read();
		if (m == root) {
			System.out.println(0);
			return;
		}
		System.out.println(recursive(root));
	}

	private static int recursive(int root) {
		int child = 0;
		for (int n : graph.get(root)) {
			if (n != m) {
				int grandChild = recursive(n);
				child += grandChild == 0 ? 1 : grandChild;
			}
		}
		return child == 0 ? 1 : child;
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
