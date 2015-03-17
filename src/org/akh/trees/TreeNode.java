package org.akh.trees;

public class TreeNode {

	private int key;

	private TreeNode left = null;
	private TreeNode right = null;

	public TreeNode(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}