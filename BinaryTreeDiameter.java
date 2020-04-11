/*
Day 11

Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is
the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
This binary tree has a diameter of 3.
          1
         / \
        2   3
       / \
      4   5
*/

import java.lang.Math;

class BinaryTreeDiameter {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        return (1 + Math.max(getHeight(node.left), getHeight(node.right)));
    }

    public static int diameter(TreeNode root) {
        if(root==null){
            return 0;
        }

        int left_height = getHeight(root.left);
        int right_height = getHeight(root.right);

        int left_diameter = diameter(root.left);
        int right_diameter = diameter(root.right);

        int left_and_right_heights = left_height + right_height;
        int left_and_right_diameters = Math.max(left_diameter, right_diameter);

        return Math.max(left_and_right_heights, left_and_right_diameters);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(13);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.left.right = new TreeNode(9);

        System.out.println(getHeight(root));//5
        System.out.println(diameter(root));//6
    }

}