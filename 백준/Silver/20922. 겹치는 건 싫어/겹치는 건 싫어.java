import java.util.HashMap;
import java.util.HashSet;

public class Main {

	static int n, k;
	static HashMap<Integer, Integer> hm;
	static HashSet<Integer> hs;
	public static void main(String[] args) throws Exception {
		n = read();
		k = read();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		hm = new HashMap<>();
		hs = new HashSet<>();
		int l = 0, r = 0, maxLen = 0;
		while (r < n) {
			hm.putIfAbsent(arr[r], 0);
			hm.replace(arr[r], hm.get(arr[r]) + 1);
			if (hm.get(arr[r]) > k)
				hs.add(arr[r]);
			while (!isValid()) {
				hm.replace(arr[l], hm.get(arr[l]) - 1);
				if (hs.contains(arr[l]) && hm.get(arr[l]) <= k)
					hs.remove(arr[l]);
				l++;
			}
			maxLen = Math.max(maxLen, r - l + 1);
			r++;
		}
		System.out.println(maxLen);
	}

	private static boolean isValid() {
		for (int t : hs)
			if (hm.get(t) >= k)
				return false;
		return true;

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
