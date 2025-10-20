public class Main {
	public static void main(String[] args) {
		// BST tree = new BST();
		//
		// tree.add(4);
		// tree.add(1);
		// tree.add(3);
		// tree.add(2);
		// tree.add(5);
		//
		// tree.descendingTraversal();  // 내림차순: 5 4 3 2 1
		// tree.ascendingTraversal();   // 오름차순: 1 2 3 4 5
		//
		// System.out.println(tree.search(3) ? "3 있음" : "3 없음");
		// tree.remove(3);
		// System.out.println(tree.search(3) ? "3 있음" : "3 없음");
		//
		// tree.ascendingTraversal(); // 3 삭제 후 출력

		// 트라이
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("april");
		trie.insert("app");
		System.out.println("삽입 완료!");

		System.out.println("search(apple): " + trie.search("apple")); // true
		System.out.println("search(april): " + trie.search("april")); // true
		System.out.println("search(app): " + trie.search("app"));     // true
		System.out.println("search(ape): " + trie.search("ape"));     // false

		System.out.println("\n=== apple 삭제 ===");
		trie.delete("apple");
		System.out.println("search(apple): " + trie.search("apple")); // false
		System.out.println("search(april): " + trie.search("april")); // true (영향 없어야 함)
		System.out.println("search(app): " + trie.search("app"));     // true (영향 없어야 함)

		System.out.println("\n=== april 삭제 ===");
		trie.delete("april");
		System.out.println("search(april): " + trie.search("april")); // false
		System.out.println("search(app): " + trie.search("app"));     // true
	}
}