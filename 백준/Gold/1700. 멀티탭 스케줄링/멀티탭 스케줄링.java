import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read(), k = read();
		int cnt = 0;
		int[] arr = new int[k];
		ArrayList<Deque<Integer>> al = new ArrayList<>();
		for (int i = 0; i < k + 1; i++)
			al.add(new ArrayDeque<>());
		for (int i = 0; i < k; i++) {
			int p = read();
			arr[i] = p;
			al.get(p).offer(i);
		}
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < k; i++) {
			int p = arr[i];
			if (hs.size() < n || hs.contains(p)) {
				hs.add(p);
				al.get(p).poll();
				continue;
			}
			int q = 0, idx = 0;
			for (int j : hs) {
				if (al.get(j).size() == 0) {
					q = j;
					break;
				}
				if (idx < al.get(j).peek()) {
					q = j;
					idx = al.get(j).peek();
				}
			}
			hs.remove(q);
			cnt++;
			hs.add(p);
			al.get(p).poll();
		}
		System.out.println(cnt);
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