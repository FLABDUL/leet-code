package problems.binary_tree_bfs.validate_binary_search_tree;

public class ValidateBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();

        // root = [5,1,4,null,null,3,6]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);

        // Calculating the average of levels
        boolean result = validateBinarySearchTree.isValidBST(root);
        System.out.println("result: " + result);
    }

    public boolean isValidBST(TreeNode root) {
        TreeNode previous=null;
        if(root.left!=null){
            if(root.left.val>root.val){
                return false;
            }
            previous=root;
            isValidBST(root.left);
        }else if(root.right!=null){
            if(root.right.val<root.val){
                return false;
            }
            previous=root;
            isValidBST(root.right);
        }else{
            isValidBST(previous.right);
        }
        return true;
    }
}
