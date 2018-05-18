package org.david.basic.tree;

import java.util.List;

/**
 * 二叉树中数据结构
		8
       /  \
      6   10
     / \  / \
    5  7 9  11
 * @author hanxiaowei
 *
 */
public class TestBinaryTree {

	public static void main(String[] arg) {
		
		int[] arrs = new int[]{8,6,10,5,7,9,11};
		BinaryTree binaryTree = new BinaryTree();
		List<TreeNode> binaryTreeNodes = binaryTree.initTree(arrs);
		TreeNode rootNode = binaryTreeNodes.get(0);
		//先序遍历结果(根节点->左节点->右节点)
		System.out.println("递归先序遍历结果: ");
		binaryTree.preOrderTraverse(rootNode);
		System.out.println("\n循环先序遍历结果: ");
		binaryTree.preOrderTraverseByWhile(rootNode);
		//中序遍历结果(左节点->根节点->右节点)
		System.out.println("\n中序遍历结果: ");
		binaryTree.inOrderTraverse(rootNode);
		//后序遍历结果(左节点->右节点->根节点)
		System.out.println("\n后序遍历结果: ");
		binaryTree.afterOrderTraverse(rootNode);
	}
}
