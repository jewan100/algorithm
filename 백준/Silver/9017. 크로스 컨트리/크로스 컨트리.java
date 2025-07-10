import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		int tc = read();
		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			int n = read();
			int[] arr = new int[n];
			HashMap<Integer, ArrayList<Integer>> teams = new HashMap<>();
			HashMap<Integer, int[]> scores = new HashMap<>();
			HashSet<Integer> hs = new HashSet<>();
			for (int i = 0; i < n; i++) {
				int t = read();
				teams.putIfAbsent(t, new ArrayList<>());
				teams.get(t).add(i);
				arr[i] = t;
			}
			for (int t : teams.keySet())
				if (teams.get(t).size() >= 6)
					hs.add(t);
			int winTeam = 0;
			int winScore = Integer.MAX_VALUE;
			int d = 0;
			for (int i = 0; i < n; i++) {
				if (teams.get(arr[i]).size() < 6)
					continue;
				scores.putIfAbsent(arr[i], new int[2]);
				if (scores.get(arr[i])[1] < 4) {
					scores.get(arr[i])[0] += d;
					scores.get(arr[i])[1]++;
				}
				d++;
			}
			for (int team : scores.keySet()) {
				if (scores.get(team)[0] < winScore
						|| (scores.get(team)[0] == winScore && teams.get(team).get(4) < teams.get(winTeam).get(4))) {
					winTeam = team;
					winScore = scores.get(team)[0];
				}
			}
			sb.append(winTeam).append("\n");
		}
		System.out.println(sb);
	}

	public static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return n;
	}
}