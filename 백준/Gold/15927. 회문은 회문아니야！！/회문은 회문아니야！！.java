import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		if (len == 1) {
			System.out.println(-1);
			return;
		}
		boolean flag = true;
		HashSet<Character> hs = new HashSet<>();
		for (int i = 0; i <= len / 2; i++) {
			hs.add(str.charAt(i));
			hs.add(str.charAt(len - i - 1));
			if (str.charAt(i) != str.charAt(len - i - 1)) {
				flag = false;
			}
		}
		if (hs.size() == 1)
			System.out.println(-1);
		else if (flag)
			System.out.println(len - 1);
		else
			System.out.println(len);
	}
}