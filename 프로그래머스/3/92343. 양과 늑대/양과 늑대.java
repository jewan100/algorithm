import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Solution {
    
    class Node {
        int now;
        int sheepCnt;
        int wolfCnt;
        boolean[] visited;

        Node(int now, int sheepCnt, int wolfCnt, boolean[] visited) {
            this.now = now;
            this.sheepCnt = sheepCnt;
            this.wolfCnt = wolfCnt;
            this.visited = visited;
        }
    }
    
    public int solution(int[] info, int[][] edges) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		int n = info.length;
		for (int i = 0; i < n; i++)
			al.add(new ArrayList<>());
		for (int[] edge : edges)
			al.get(edge[0]).add(edge[1]);
		Deque<Node> dq = new ArrayDeque<>();
		dq.offer(new Node(0, 0, 0, new boolean[n]));
		int maxSheep = 0;
		while (!dq.isEmpty()) {
			Node cur = dq.poll();
			int u = cur.now, sheepCnt = cur.sheepCnt, wolfCnt = cur.wolfCnt;
			boolean[] visited = cur.visited;
			if (!visited[u]) {
				if (info[u] == 0) {
					sheepCnt++;
					maxSheep = Math.max(maxSheep, sheepCnt);
					visited[u] = true;
					dq.offer(new Node(0, sheepCnt, wolfCnt, visited.clone()));
					continue;
				} else {
					wolfCnt++;
					visited[u] = true;
				}
			}
			for (int v : al.get(u)) {
				if (info[v] == 0)
					dq.offer(new Node(v, sheepCnt, wolfCnt, visited.clone()));
				else if (sheepCnt > wolfCnt + 1)
					dq.offer(new Node(v, sheepCnt, wolfCnt, visited.clone()));
			}
		}
		return maxSheep;
	}
}