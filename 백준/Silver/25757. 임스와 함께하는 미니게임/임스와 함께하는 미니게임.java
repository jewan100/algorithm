import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("Y", 1);
		hm.put("F", 2);
		hm.put("O", 3);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = hm.get(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		while (n-- > 0)
			hs.add(br.readLine());
		System.out.println(hs.size() / t);
	}
}