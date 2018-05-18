package org.david.basic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 二叉树是每个节点最多有两个子树的结构，常用于实现二叉查找树和二叉椎
 * 
 * 三种遍历方式
	(1). 先序遍历
	(2). 中序遍历
	(3). 后序遍历
	
 *源二叉树:
 		8
       /  \
      6   10
     / \  / \
    5  7 9  11
 *镜像二叉树:
      	8
       /  \
      10   6
     / \  / \
    11 9 7  5
    
 * @author hanxiaowei
 *
 */
public class BinaryTree {

	public List<TreeNode> initTree(int[] arrs) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for(int data: arrs) {
			nodes.add(new TreeNode(data));
		}
		//此处每个父节点的index < (arrs.length / 2 - 1)是确保每个父节点的左右子节点都存在 
		for (int parentIndex = 0; parentIndex < arrs.length/2-1; parentIndex ++) {
			nodes.get(parentIndex).leftNode = nodes.get(parentIndex*2+1);
			nodes.get(parentIndex).rightNode = nodes.get(parentIndex*2+2);
		}
		//(arrs.length / 2 - 1)最后一个父节点，通过二叉树的定义可知
		int lastParentIndex = arrs.length / 2 - 1;
		nodes.get(lastParentIndex).leftNode = nodes.get(lastParentIndex * 2 + 1);
		//arrs.length % 2 != 0,作为判断最后一个父节点的右子节点是否存在的判断条件
		if(arrs.length % 2 != 0){
			nodes.get(lastParentIndex).rightNode = nodes.get(lastParentIndex * 2 + 2);
		}
		return nodes;
	}
	/**
	 * 先序遍历(递归): "根左右"，遍历的顺序: 根节点->左节点->右节点。
	 * @param node
	 */
	public void preOrderTraverse(TreeNode node){
		if(node == null)
			return;
		System.out.print(node.data + " ");//第一次进入是根节点
		preOrderTraverse(node.leftNode);//递归输出左节点
		preOrderTraverse(node.rightNode);//递归输出右节点
	}
	/**
	 * 先序遍历(循环): "根左右"，遍历的顺序: 根节点->左节点->右节点。
	 * @param node
	 */
	public void preOrderTraverseByWhile(TreeNode node){
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(node);
		TreeNode currentNode;
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			System.out.print(currentNode.data + " ");
			if(currentNode.rightNode != null){
				stack.push(currentNode.rightNode);
			}
			if (currentNode.leftNode != null) {
				stack.push(currentNode.leftNode);
			}
		}
	}
	/**
	 * 中序遍历(递归): "左根右"，遍历的顺序: 左节点->根节点->右节点。
	 * @param node
	 */
	public void inOrderTraverse(TreeNode node){
		if(node == null)
			return;
		inOrderTraverse(node.leftNode); //递归输出左节点
		System.out.print(node.data + " "); 
		inOrderTraverse(node.rightNode); //递归输出右节点
	}
	/**
	 * 后序遍历(递归): "左右根"，遍历的顺序: 左节点->右节点->根节点。
	 * @param node
	 */
	public void afterOrderTraverse(TreeNode node){
		if(node == null)
			return;
		afterOrderTraverse(node.leftNode);//递归输出左节点
		afterOrderTraverse(node.rightNode);//递归输出右节点
		System.out.print(node.data + " ");
	}
}
