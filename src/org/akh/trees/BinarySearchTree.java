package org.akh.trees;

public class BinarySearchTree implements ITree {

	private TreeNode root = null;

	public TreeNode getRoot() {
		return root;
	}

	@Override
	public void insert(TreeNode obj) {
		if (root == null) {
			root = obj;
			return;
		}

		TreeNode pointer = getRoot();

		do {
			if (obj.getKey() > pointer.getKey()) {
				if (pointer.getRight() == null) {
					pointer.setRight(obj);
					break;
				}

				pointer = pointer.getRight();
			} else {
				if (pointer.getLeft() == null) {
					pointer.setLeft(obj);
					break;
				}
				pointer = pointer.getLeft();
			}

		} while (pointer != null);

	}

	public void insert(int val) {
		TreeNode treeNode = new TreeNode(val);
		this.insert(treeNode);
	}

	@Override
	public void remove(TreeNode obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(int key) {

		return contains(root, key);
	}

	public boolean contains(TreeNode node, int key) {
		if (key == node.getKey())
			return true;

		if (key > node.getKey() && node.getRight() != null)
			return contains(node.getRight(), key);
		if (key < node.getKey() && node.getLeft() != null)
			return contains(node.getLeft(), key);

		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void forEach(Object handler) {
		// TODO Auto-generated method stub

	}

	public void printInOrderWalk(TreeNode node) {
		if (node == null)
			return;

		printInOrderWalk(node.getLeft());

		System.out.println(node.getKey());

		printInOrderWalk(node.getRight());

	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();

		bst.insert(7);
		bst.insert(5);
		bst.insert(6);
		bst.insert(2);
		bst.insert(9);
		bst.insert(8);

		System.out.println("walk started");

		bst.printInOrderWalk(bst.getRoot());

		System.out.println("walk ended\n=============");

		for (int i = 0; i < 10; i++) {

			System.out.println(String.valueOf(i)
					+ (bst.contains(i) ? " found" : " NOT found"));
		}

	}

}
