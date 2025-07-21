import java.util.ArrayList;

public class Main {

	static class Team {
		int[] scores;
		int totalScore = 0;
		int submitCnt = 0;
		int lastSubmit = 0;
		int id;

		Team(int i, int j) {
			this.id = i;
			scores = new int[j];
		}
	}

	public static void main(String[] args) throws Exception {
		int tc = read();
		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			int n = read(), k = read(), t = read(), m = read();
			ArrayList<Team> teams = new ArrayList<>();
			for (int i = 0; i < n; i++)
				teams.add(new Team(i + 1, k));
			for (int l = 0; l < m; l++) {
				int i = read() - 1, j = read() - 1, s = read();
				Team team = teams.get(i);
				team.lastSubmit = l;
				team.submitCnt++;
				if (team.scores[j] < s) {
					team.totalScore -= team.scores[j];
					team.scores[j] = s;
					team.totalScore += team.scores[j];
				}
			}
			teams.sort((t1, t2) -> t2.totalScore != t1.totalScore
					? t2.totalScore - t1.totalScore
					: t1.submitCnt != t2.submitCnt ? t1.submitCnt - t2.submitCnt : t1.lastSubmit - t2.lastSubmit);
			for (int i = 0; i < n; i++)
				if (teams.get(i).id == t) {
					sb.append(i + 1).append("\n");
					break;
				}
		}
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
