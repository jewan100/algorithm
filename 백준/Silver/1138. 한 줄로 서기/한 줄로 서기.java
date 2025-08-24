import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		int n = read();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = read();
		List<Integer> ls = new ArrayList<>();
		for (int i = n - 1; i >= 0; i--)
			ls.add(arr[i], i + 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(ls.get(i)).append(" ");
		System.out.println(sb);
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
