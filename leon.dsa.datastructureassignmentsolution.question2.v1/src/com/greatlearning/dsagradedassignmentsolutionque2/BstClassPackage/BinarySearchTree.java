package com.greatlearning.dsagradedassignmentsolutionque2.BstClassPackage;


public class BinarySearchTree {
	
	//BST Node
	public static class Node{
		int nodeData;
		Node left,right;
		public Node (int nodeData) {
			this.nodeData=nodeData;
			left=right=null;
		}
	}
	
	public static Node node;
    
    static Node headNode = null;
    static Node parentNode = null;
    
    // Converting to Skewed Tree
    static void SkewBT(Node root) {
    	if(root==null) {
    		return;
        }
    	
    	SkewBT(root.left);
    	
    	Node rightNode=root.right;
    	
        if(headNode==null) {
            headNode=root;
            root.left=null;
            parentNode=root;
        } else {
            parentNode.right=root;
            root.left=null;
            parentNode=root;
        }
        
        SkewBT(rightNode);
    }
    
	static void printRightSkewed(Node root){
	    if(root==null){
	    	return;
	    }
	    System.out.print(root.nodeData + " ");
	    printRightSkewed(root.right);       
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree tree1=new BinarySearchTree();
		tree1.node=new Node(50);
		tree1.node.left=new Node(30);
		tree1.node.right=new Node(60);
		tree1.node.left.left=new Node(10);
		tree1.node.right.left=new Node(55);
		
		SkewBT(node);
		printRightSkewed(headNode);
		
	}

}
