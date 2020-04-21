
/*
Day 20

Return the root node of a binary search tree that matches the given preorder traversal.

Note: 
1 <= preorder.length <= 100
The values of preorder are distinct.

Example:
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
*/

final class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }

}

class PreorderTraversal{

    public static void insertNode(TreeNode trav_node, TreeNode new_node){
        System.out.println("val: " + new_node.val);
        if(new_node.val < trav_node.val){
            if(trav_node.left==null){
                trav_node.left = new_node;
                return;
            }
            else{
                System.out.println("2");
                insertNode(trav_node.left, new_node);
            }
        }
        else{
            if(trav_node.right==null){
                System.out.println("3");
                trav_node.right = new_node;
                return;
            }
            else{
                System.out.println("4");
                insertNode(trav_node.right, new_node);
            }
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int length = preorder.length;
        if(length == 1){
            return root;
        }

        for(int i=1; i<length; i++){
            TreeNode new_node = new TreeNode(preorder[i]);
            insertNode(root, new_node);
        }
        return root;
    }
    
    public static void main(String[] args) {
        int[] nums = {8,5,1,7,10,12};
        System.out.println(bstFromPreorder(nums));
    }

}