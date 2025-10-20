public class BST {

	static class Node {
		Node left, right;
		Integer key;
		public Node(Integer key) {
			this.key = key;
		}
	}

	private Node root;

	/** 노드 삽입 **/
	public void add(int key) {
		Node newNode = new Node(key);
		if (root == null) root = newNode;
		else root = addNode(root, newNode);
	}

	private Node addNode(Node node, Node newNode) {
		if (node == null) return newNode;
		if (node.key < newNode.key) node.right = addNode(node.right, newNode);
		else node.left = addNode(node.left, newNode);
		return node;
	}

	/** 노드 삭제 **/
	public void remove(int key) {
		root = removeNode(root, key);
	}

	private Node removeNode(Node node, int key) {
		if (node == null)
			throw new RuntimeException("해당 값을 가진 노드를 찾을 수 없습니다.");

		if (node.key > key) {
			node.left = removeNode(node.left, key);
		} else if (node.key < key) {
			node.right = removeNode(node.right, key);
		} else {
			if (node.left != null) {
				Node child = findMaxNode(node.left);
				int removeKey = node.key;
				node.key = child.key;
				child.key = removeKey;
				node.left = removeNode(node.left, removeKey);
			} else if (node.right != null) {
				Node child = findMinNode(node.right);
				int removeKey = node.key;
				node.key = child.key;
				child.key = removeKey;
				node.right = removeNode(node.right, removeKey);
			} else {
				return null;
			}
		}
		return node;
	}

	private Node findMaxNode(Node node) {
		if (node.right == null) return node;
		return findMaxNode(node.right);
	}

	private Node findMinNode(Node node) {
		if (node.left == null) return node;
		return findMinNode(node.left);
	}

	/** 노드 탐색 **/
	public boolean search(int key) {
		return searchNode(root, key) != null;
	}

	private Node searchNode(Node node, int key) {
		if (node == null) return null;
		if (node.key.equals(key)) return node;
		if (node.key > key) return searchNode(node.left, key);
		else return searchNode(node.right, key);
	}

	/** 오름차순 순회 **/
	public void ascendingTraversal() {
		System.out.print("오름차순 순회: ");
		leftInorderTraversal(root);
		System.out.println();
	}

	private void leftInorderTraversal(Node node) {
		if (node == null) return;
		leftInorderTraversal(node.left);
		System.out.printf("%d ", node.key);
		leftInorderTraversal(node.right);
	}

	/** 내림차순 순회 **/
	public void descendingTraversal() {
		System.out.print("내림차순 순회: ");
		rightInorderTraversal(root);
		System.out.println();
	}

	private void rightInorderTraversal(Node node) {
		if (node == null) return;
		rightInorderTraversal(node.right);
		System.out.printf("%d ", node.key);
		rightInorderTraversal(node.left);
	}
}