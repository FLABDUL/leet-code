package problems.binary_tree_bfs.kth_smallest_element_bst;

public class KthSmallestElementBstLog {
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
        KthSmallestElementBstLog kthSmallestElementBstLog = new KthSmallestElementBstLog();

        // Creating the binary search tree (BST)
        // root = [3,1,4,null,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        // Calculating the kth smallest element for k = 1
        int result = kthSmallestElementBstLog.kthSmallest(root, 1);
        System.out.println("Result: " + result); // Expected output: 1
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            System.out.println("TreeNode is null, returning 0.");
            return 0;
        }

        // Count the nodes in the left subtree
        int count = countNodes(root.left);
        System.out.println("Current Node: " + root.val + ", Count of left subtree nodes: " + count);

        if (k <= count) {
            System.out.println("k (" + k + ") is in the left subtree.");
            return kthSmallest(root.left, k); // Explore left subtree
        } else if (k > count + 1) {
            System.out.println("k (" + k + ") is in the right subtree. Adjusting k to " + (k - 1 - count));
            return kthSmallest(root.right, k - 1 - count); // Explore right subtree
        }

        // Found the kth smallest element
        System.out.println("k (" + k + ") matches current node. Returning value: " + root.val);
        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) {
            System.out.println("Null node encountered in countNodes, returning 0.");
            return 0;
        }

        int leftCount = countNodes(n.left);
        int rightCount = countNodes(n.right);

        int total = 1 + leftCount + rightCount;
        System.out.println("Node " + n.val + " has " + leftCount + " left nodes and " + rightCount + " right nodes. Total: " + total);
        return total;
    }
}

// Algorithm Used:
// This solution utilizes the **Binary Search Tree (BST) property** and recursion to determine the kth smallest element.
// The approach is similar to an in-order traversal, which retrieves elements in sorted order for BSTs.

// Pros:
// - Efficient when the tree is balanced, as each subtree search reduces the size of the problem significantly.
// - The BST property ensures that left children are smaller and right children are larger, making the logic straightforward.

// Cons:
// - Performance can degrade for skewed trees (linked-list-like), leading to O(n) time complexity in the worst case.
// - Requires additional recursive stack space.

// Uses:
// - Common in scenarios where data is stored in a BST and ranked queries (like kth smallest/largest) need to be efficiently performed.
// - Foundational concept for advanced algorithms in databases and search problems.

// Time Complexity:
// - Average case: O(H + k), where H is the height of the tree (log n for balanced trees, n for skewed trees).
// - Worst case: O(n), when the tree is completely unbalanced.

// Space Complexity:
// - O(H) for the recursive stack, where H is the height of the tree (log n for balanced, n for unbalanced).
