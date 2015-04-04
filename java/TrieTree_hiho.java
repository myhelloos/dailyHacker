import java.util.Scanner;

public class TrieTree_hiho {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		TrieTree trieTree = new TrieTree();
		int numbers = in.nextInt();
		for (int i = 0; i < numbers; i++) {
			trieTree.add(in.next());
		}
		int times = in.nextInt();
		for (int i = 0; i < times; i++) {
			System.out.println(trieTree.countPrefixs(in.next()));
		}
		in.close();
	}
}

class TrieTree {
	Trie root;
	public TrieTree() {
		root = new Trie();
	}

	public void add(String word) {
		add(root, word);
	}

	public int countWords(String word) {
		return countWords(root, word);
	}

	public int countPrefixs(String prefix) {
		return countPrefixs(root, prefix);
	}

	private int countPrefixs(Trie cur, String prefix) {
		if (prefix.isEmpty()) {
			return cur.prefixes;
		} else {
			int edge = prefix.charAt(0) - 'a';
			if (cur.edges[edge] == null) {
				return 0;
			} else {
				return countPrefixs(cur.edges[edge], prefix.substring(1));
			}
		}
	}

	private int countWords(Trie cur, String word) {
		if (word.isEmpty()) {
			return cur.words;
		} else {
			int edge = word.charAt(0) - 'a';
			if (cur.edges[edge] == null) {
				return 0;
			} else {
				return countWords(cur.edges[edge], word.substring(1));
			}
		}
	}

	private void add(Trie cur, String word) {
		if (word.isEmpty()) {
			cur.words++;
		} else {
			cur.prefixes++;
			int edge = word.charAt(0) - 'a';
			if (cur.edges[edge] == null) {
				cur.edges[edge] = new Trie();
			}
			add(cur.edges[edge], word.substring(1));
		}
	}
}

class Trie {
	int words;
	int prefixes;

	Trie[] edges = new Trie[26];
}
