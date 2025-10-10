import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static class TrieNode {
		TrieNode[] children;
		boolean isEndOfWord;
		int cnt;

		public TrieNode() {
			children = new TrieNode[26];
			isEndOfWord = false;
			cnt = 0;
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String str) {
			TrieNode cur = root;
			for (int i = 0; i < str.length(); i++) {
				int idx = str.charAt(i) - 'a';
				if (cur.children[idx] == null) {
					cur.children[idx] = new TrieNode();
					cur.cnt++;
				}
				cur = cur.children[idx];
			}
			cur.isEndOfWord = true;
		}

		public double calculate(String[] words) {
			double total = 0;
			for (String word : words) {
				total += getPressCount(word);
			}
			return total / words.length;
		}

		private int getPressCount(String word) {
			TrieNode cur = root;
			int press = 0;
			for (int i = 0; i < word.length(); i++) {
				int idx = word.charAt(i) - 'a';
				cur = cur.children[idx];
				if (cur.cnt > 1 || cur.isEndOfWord)
					press++;
			}
			return press;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while ((str = br.readLine()) != null) {
			int n = Integer.parseInt(str);
			Trie trie = new Trie();
			String[] words = new String[n];
			for (int i = 0; i < n; i++) {
				words[i] = br.readLine();
				trie.insert(words[i]);
			}
			sb.append(String.format("%.2f", trie.calculate(words))).append("\n");
		}
		System.out.println(sb);
	}
}