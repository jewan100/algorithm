import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[] s, t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine().toCharArray();
		t = br.readLine().toCharArray();
		System.out.println(recursive(0, t.length - 1, true) ? 1 : 0);
	}

	private static boolean recursive(int l, int r, boolean flag) {
		if (r - l + 1 == s.length)
			return isValid(l, r, flag);
		if (flag) {
			if (t[l] == 'B' && recursive(l + 1, r, !flag))
				return true;
			if (t[r] == 'A' && recursive(l, r - 1, flag))
				return true;
		} else {
			if (t[l] == 'A' && recursive(l + 1, r, flag))
				return true;
			if (t[r] == 'B' && recursive(l, r - 1, !flag))
				return true;
		}
		return false;
	}

	private static boolean isValid(int l, int r, boolean flag) {
		for (int i = 0; i < s.length; i++) {
			if (flag && s[i] != t[l + i])
				return false;
			else if (!flag && s[i] != t[r - i])
				return false;
		}
		return true;
	}
}