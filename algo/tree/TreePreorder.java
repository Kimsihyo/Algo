package tree;

import java.util.Scanner;

class Tr22 {
	class Node {
		int data;
		Node left, right;
	}

	Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void makeTree(int d1, int d2) {
		if (root == null) {
			root = new Node();
			root.data = d1;
		}
		makeTree(root, d1, d2);
	}

	public Node makeTree(Node root, int d1, int d2) {
		if (root == null) {
			root = new Node();
			root.data = d2;
			return root;
		}

		if (root.data == d1) {
			if (root.left == null)
				root.left = makeTree(root.left, d1, d2);
			else if (root.right == null)
				root.right = makeTree(root.right, d1, d2);
			return root;
		}
		makeTree(root.left, d1, d2);
		makeTree(root.right, d1, d2);
		return root;
	}

	public void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

}

/*
 * 13 1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
 */
public class TreePreorder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tr22 t = new Tr22();
		int N = sc.nextInt();

		for (int i = 0; i < N - 1; i++) {
			int d1 = sc.nextInt();
			int d2 = sc.nextInt();
			t.makeTree(d1, d2);
		}
		t.preorder(t.root);
		sc.close();
	}
}