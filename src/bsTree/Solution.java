package bsTree;

import java.util.ArrayList;

public class Solution {
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode convertBST(TreeNode root) {
		preOrder(root);
		addOrder(root);
		return root;
	}
	
	ArrayList<Integer> arrayList=new ArrayList<>();
	public void preOrder(TreeNode node){
		if(node==null) {
			return ;
		}
		arrayList.add(node.val);
		preOrder(node.left);
		preOrder(node.right);
	}
	public void addOrder(TreeNode node) {
		if(node==null) {
			return;
		}
		for(int item:arrayList) {
			if(item>node.val) {
				node.val+=item;
			}	
		}
		addOrder(node.left);
		addOrder(node.right);
	}

}
