package org.akh.trees;

public interface ITree {

	void insert(TreeNode obj);

	void remove(TreeNode obj);

	boolean contains(int key);

	int size();

	/*
	 * Calls the handler for each element in the tree in sorted order (from the
	 * lowest to the largest element)
	 */
	void forEach(Object handler);
}