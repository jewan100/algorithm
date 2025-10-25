import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static class Node {
		Node[] next;
		boolean isEnd;
		int cnt;

		public Node() {
			this.next = new Node[26];
			this.isEnd = false;
			this.cnt = 0;
		}
	}

	private static class Trie {
		Node root;

		public Trie() {
			this.root = new Node();
		}

		public String insert(String str) {
			Node cur = root;
			boolean flag = true;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				if (flag)
					sb.append(str.charAt(i));
				if (cur.next[idx] == null) {
					flag = false;
					cur.next[idx] = new Node();
				}
				cur = cur.next[idx];
			}
			cur.cnt++;
			if (cur.isEnd)
				sb.append(cur.cnt);
			else
				cur.isEnd = true;
			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		StringBuilder sb = new StringBuilder();
		while (n-- > 0)
			sb.append(trie.insert(br.readLine())).append("\n");
		System.out.println(sb);
	}
}