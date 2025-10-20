public class Main {
	public static void main(String[] args) {
		BST tree = new BST();

		tree.add(4);
		tree.add(1);
		tree.add(3);
		tree.add(2);
		tree.add(5);

		tree.descendingTraversal();  // 내림차순: 5 4 3 2 1
		tree.ascendingTraversal();   // 오름차순: 1 2 3 4 5

		System.out.println(tree.search(3) ? "3 있음" : "3 없음");
		tree.remove(3);
		System.out.println(tree.search(3) ? "3 있음" : "3 없음");

		tree.ascendingTraversal(); // 3 삭제 후 출력
	}
}