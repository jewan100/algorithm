import java.util.ArrayList;

public class Main {

	static int n, s;
	static int[] arr;
	static ArrayList<Integer> lArr = new ArrayList<>();
	static ArrayList<Integer> rArr = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		n = read();
		s = read();
		arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		sum(0, n / 2, 0, lArr);
		sum(n / 2, n, 0, rArr);
		lArr.sort((o1, o2) -> o1 - o2);
		rArr.sort((o1, o2) -> o1 - o2);
		long cnt = 0;
		for (int i : lArr) {
			int sum = s - i;
			cnt += binarySearch(sum, false) - binarySearch(sum, true);
		}
		if (s == 0)
			cnt--;
		System.out.println(cnt);
	}

	private static int binarySearch(int target, boolean flag) {
		int l = 0, r = rArr.size();
		while (l < r) {
			int mid = (l + r) / 2;
			if (rArr.get(mid) > target || (flag && rArr.get(mid) == target))
				r = mid;
			else
				l = mid + 1;
		}
		return l;
	}

	private static void sum(int s, int e, int sum, ArrayList<Integer> al) {
		if (s == e) {
			al.add(sum);
			return;
		}
		sum(s + 1, e, sum, al);
		sum(s + 1, e, sum + arr[s], al);
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