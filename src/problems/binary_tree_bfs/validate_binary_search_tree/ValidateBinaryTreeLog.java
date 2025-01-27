package problems.binary_tree_bfs.validate_binary_search_tree;

import java.util.Stack;

public class ValidateBinaryTreeLog {
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
        ValidateBinaryTreeLog validateBinaryTreeLog = new ValidateBinaryTreeLog();

        // Test case: root = [5,1,4,null,null,3,6]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        // Log the initial tree structure
        System.out.println("Starting validation for the binary tree:");
        printTree(root, 0);

        // Validate the binary search tree
        boolean result = validateBinaryTreeLog.isValidBST(root);
        System.out.println("Validation result: " + result);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true; // An empty tree is a valid BST

        Stack<TreeNode> stack = new Stack<>(); // Used for iterative in-order traversal
        TreeNode pre = null; // Used to keep track of the previous node in in-order traversal

        while (root != null || !stack.isEmpty()) {
            // Traverse the left subtree
            while (root != null) {
                System.out.println("Pushing node with value: " + root.val);
                stack.push(root);
                root = root.left;
            }

            // Visit the current node
            root = stack.pop();
            System.out.println("Visiting node with value: " + root.val);

            // Compare current node's value with the previous node's value
            if (pre != null) {
                System.out.println("Comparing with previous value: " + pre.val);
                if (root.val <= pre.val) {
                    System.out.println("Invalid BST: current value " + root.val + " <= previous value " + pre.val);
                    return false;
                }
            }

            // Update the previous node
            pre = root;

            // Traverse the right subtree
            root = root.right;
        }

        // If no violations found, the tree is a valid BST
        System.out.println("Tree is a valid BST");
        return true;
    }

    // Helper method to print the tree structure
    private static void printTree(TreeNode root, int level) {
        if (root == null) return;

        printTree(root.right, level + 1);
        System.out.println("  ".repeat(level) + root.val);
        printTree(root.left, level + 1);
    }

}

/*
 * TIME COMPLEXITY:
 * - O(n): Each node in the tree is visited exactly once during the in-order traversal.
 * - During the traversal:
 *   1. Each node is pushed onto the stack once when traversing down the left subtree.
 *   2. Each node is popped from the stack exactly once when visited.
 * - Total work per node is constant, making the overall complexity O(n), where n is the number of nodes in the tree.
 *
 * SPACE COMPLEXITY:
 * - O(h): h is the height of the tree, which determines the maximum size of the stack.
 * - The stack is used to simulate the recursive behavior of an in-order traversal.
 * - In the best case (a perfectly balanced tree), h = log(n), so space complexity is O(log(n)).
 * - In the worst case (a completely unbalanced tree), h = n, so space complexity is O(n).
 * - Additional variables like `pre` and logging do not significantly impact space usage.
 */

/*
 * WHY THIS APPROACH IS ITERATIVE IN-ORDER TRAVERSAL:
 * - In-order traversal visits nodes in ascending order for a BST (left -> root -> right).
 * - The stack is used to simulate the recursive calls of a typical in-order traversal.
 * - During traversal, we compare the current node's value with the previous node's value.
 * - If the values are not in strictly increasing order, the tree is not a valid BST.
 */

/*
 * PROS:
 * - Avoids recursion, which eliminates the risk of stack overflow for deep trees.
 * - Linear time complexity makes it efficient for large trees.
 *
 * CONS:
 * - Requires additional space for the stack, which can be significant for highly unbalanced trees.
 */

