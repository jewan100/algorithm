import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Player {
		int l;
		String n;

		Player(int l, String n) {
			this.l = l;
			this.n = n;
		}
	}

	static class Room {
		int s, e;
		PriorityQueue<Player> pq;

		Room(int s, int e) {
			this.s = s;
			this.e = e;
			pq = new PriorityQueue<>((p1, p2) -> p1.n.compareTo(p2.n));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		ArrayList<Room> al = new ArrayList<>();
		loop: while (p-- > 0) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			Player pl = new Player(l, n);
			int s = l - 10, e = l + 10;
			for (Room r : al) {
				if (r.pq.size() >= m)
					continue;
				if (r.s <= l && l <= r.e) {
					r.pq.add(pl);
					continue loop;
				}
			}
			al.add(new Room(s, e));
			al.get(al.size() - 1).pq.add(pl);
		}
		StringBuilder sb = new StringBuilder();
		for (Room r : al) {
			if (r.pq.size() == m)
				sb.append("Started!");
			else
				sb.append("Waiting!");
			sb.append("\n");
			while (!r.pq.isEmpty()) {
				Player pl = r.pq.poll();
				sb.append(pl.l).append(" ").append(pl.n).append("\n");
			}
		}
		System.out.println(sb);
	}
}