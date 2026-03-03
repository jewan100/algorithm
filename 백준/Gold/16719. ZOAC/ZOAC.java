import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String str;
	static StringBuilder sb = new StringBuilder();
	static boolean[] bArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		bArr = new boolean[str.length()];
		recursive(0, str.length() - 1);
		System.out.println(sb);
	}

	private static void recursive(int l, int r) {
		if (l > r)
			return;
		int idx = r;
		char c = 'Z';
		for (int i = l; i <= r; i++) {
			if (str.charAt(i) < c) {
				c = str.charAt(i);
				idx = i;
			}
		}
		bArr[idx] = true;
		for (int i = 0; i < bArr.length; i++) {
			if (bArr[i])
				sb.append(str.charAt(i));
		}
		sb.append("\n");
		recursive(idx + 1, r);
		recursive(l, idx - 1);
	}
}