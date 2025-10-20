import java.util.HashMap;

public class Trie {

	Node root;
	static class Node {
		HashMap<Character, Node> child;
		boolean isEnd;

		public Node() {
			this.child = new HashMap<>();
			this.isEnd = false;
		}
	}

	public Trie(){
		root = new Node();
	}

	public void insert(String str){
		Node node = this.root;

		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);

			node.child.putIfAbsent(c, new Node());
			node = node.child.get(c);
		}

		node.isEnd = true;
	}
	public boolean search(String str){
		Node node = this.root;

		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);

			if(node.child.containsKey(c)){
				node = node.child.get(c);
			} else {
				return false;
			}
		}
		return node.isEnd;
	}

	public boolean delete(String str){
		boolean result = delete(this.root, str, 0);
		return false;
	}

	public boolean delete(Node node, String str, int idx){
		char c = str.charAt(idx);

		if(!node.child.containsKey(c)){
			return false;
		}

		Node cur = node.child.get(c);
		idx++;
		if(idx == str.length()){
			if(!cur.isEnd){
				return false;
			}
			cur.isEnd = false;

			if(cur.child.isEmpty()){
				node.child.remove(c);
			}
		} else {
			if(!this.delete(cur, str, idx)){
				return false;
			}
			if(!cur.isEnd && node.child.isEmpty()){
				node.child.remove(c);
			}
		}
		return true;
	}
}
