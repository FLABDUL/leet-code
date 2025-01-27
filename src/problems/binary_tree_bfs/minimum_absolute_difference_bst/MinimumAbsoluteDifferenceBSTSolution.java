package problems.binary_tree_bfs.minimum_absolute_difference_bst;

public class MinimumAbsoluteDifferenceBSTSolution {
    // Definition for a binary tree node
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceBSTSolution minimumAbsoluteDifferenceBSTSolution = new MinimumAbsoluteDifferenceBSTSolution();

        // Create test tree: root = [4,2,6,1,3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        // Get result and print it
        int result = minimumAbsoluteDifferenceBSTSolution.getMinimumDifference(root);
        System.out.println("Result: " + result); // Log final result
    }

    int min = Integer.MAX_VALUE; // To store minimum difference
    Integer prev = null; // To store the previous node value during traversal

    /**
     * Method to find the minimum absolute difference in a BST.
     *
     * @param root Root of the BST.
     * @return Minimum absolute difference.
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            System.out.println("Encountered a null node, returning current min: " + min);
            return min; // Base case: return current min if node is null
        }

        // Recursive call for left subtree
        System.out.println("Traversing left subtree of node with value: " + root.val);
        getMinimumDifference(root.left);

        // Log current node and previous value
        System.out.println("Visiting Node: " + root.val + (prev != null ? ", Previous Node: " + prev : ", No Previous Node"));

        // Update min using the current and previous node values
        if (prev != null) {
            int difference = root.val - prev;
            System.out.println("Current difference between " + root.val + " and " + prev + ": " + difference);
            min = Math.min(min, difference);
            System.out.println("Updated Min: " + min);
        } else {
            System.out.println("No previous node to compare with for node: " + root.val);
        }
        prev = root.val; // Update previous value to the current node value

        // Recursive call for right subtree
        System.out.println("Traversing right subtree of node with value: " + root.val);
        getMinimumDifference(root.right);

        return min; // Return the minimum difference
    }
}

// --------------------------------------------
// Pros:
// 1. Efficient for BSTs due to sorted order in inorder traversal.
// 2. Simple and easy-to-understand recursive approach.
//
// Cons:
// 1. Recursive stack space may lead to StackOverflowError for deep trees.
// 2. Does not handle non-BST inputs; assumes the tree is a valid BST.
//
// Uses:
// 1. Finding the closest pair of values in a BST.
// 2. Preprocessing for problems involving differences between tree node values.
//
// Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
// Time Complexity: O(n), where n is the number of nodes in the tree (inorder traversal).
//
// Algorithm Used: Inorder Traversal
