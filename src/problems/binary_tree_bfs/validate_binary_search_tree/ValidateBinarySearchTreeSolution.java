package problems.binary_tree_bfs.validate_binary_search_tree;

import java.util.Stack;

public class ValidateBinarySearchTreeSolution {
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
        ValidateBinarySearchTreeSolution validateBinarySearchTreeSolution = new ValidateBinarySearchTreeSolution();

        // root = [5,1,4,null,null,3,6]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);

        // Calculating the average of levels
        boolean result = validateBinarySearchTreeSolution.isValidBST(root);
        System.out.println("result: " + result);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
