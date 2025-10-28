import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		Node[] next;
		boolean isEnd;

		Node() {
			this.next = new Node[26];
			this.isEnd = false;
		}
	}

	static class Trie {
		Node root;

		Trie() {
			this.root = new Node();
		}

		public void insert(String str) {
			Node cur = root;
			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				if (cur.next[idx] == null)
					cur.next[idx] = new Node();
				cur = cur.next[idx];
			}
			cur.isEnd = true;
		}

		public boolean judge(String str) {
			Node cur = root;
			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				if (cur.isEnd && hs.contains(str.substring(i)))
					return true;
				if (cur.next[idx] == null)
					return false;
				cur = cur.next[idx];
			}
			return false;
		}
	}

	static HashSet<String> hs = new HashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();
		for (int i = 0; i < n; i++)
			trie.insert(br.readLine());
		for (int i = 0; i < m; i++)
			hs.add(br.readLine());
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++)
			sb.append(trie.judge(br.readLine()) ? "Yes" : "No").append("\n");
		System.out.println(sb);
	}
}