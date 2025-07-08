import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		while (!(str = br.readLine()).equals("end"))
			sb.append(judge(str));
		System.out.println(sb);
	}

	public static String judge(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append("<").append(str).append("> is ");
		int cntV = 0, cntC = 0;
		boolean appeared = false;
		boolean isPossible = true;
		Deque<Character> dq = new ArrayDeque<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != 'e' && c != 'o')
				if (!dq.isEmpty() && dq.peekLast() == c) {
					isPossible = false;
					break;
				}
			dq.offer(c);
			if (dq.size() > 3) {
				if (isVowel(dq.pollFirst()))
					cntV--;
				else
					cntC--;
			}
			if (isVowel(c)) {
				cntV++;
				appeared = true;
			} else
				cntC++;
			if (cntV == 3 || cntC == 3) {
				isPossible = false;
				break;
			}
		}
		if (!isPossible || !appeared)
			sb.append("not ");
		return sb.append("acceptable.\n").toString();
	}

	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
