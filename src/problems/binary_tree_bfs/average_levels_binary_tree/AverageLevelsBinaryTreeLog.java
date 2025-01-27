package problems.binary_tree_bfs.average_levels_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTreeLog {
    // Definition for a binary tree node
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
        AverageLevelsBinaryTreeLog averageLevelsBinaryTreeLog = new AverageLevelsBinaryTreeLog();

        // Creating the tree structure as described in the input [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Log the structure of the tree
        System.out.println("Tree structure created: [3,9,20,null,null,15,7]");

        // Calculating the average of levels
        List<Double> result = averageLevelsBinaryTreeLog.averageOfLevels(root);

        // Log the result
        System.out.println("Average values of levels: " + result);
    }

    /**
     * Calculates the average value of nodes on each level of the binary tree.
     * @param root Root of the binary tree
     * @return List of averages of each level
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            System.out.println("The tree is empty. Returning an empty result.");
            return result;
        }

        q.add(root);
        System.out.println("Starting level order traversal...");

        while (!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            System.out.println("Processing level with " + n + " nodes...");

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                System.out.println("Visiting node with value: " + node.val);
                sum += node.val;

                if (node.left != null) {
                    System.out.println("Adding left child to queue: " + node.left.val);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    System.out.println("Adding right child to queue: " + node.right.val);
                    q.offer(node.right);
                }
            }

            double average = sum / n;
            System.out.println("Average for this level: " + average);
            result.add(average);
        }

        System.out.println("Traversal complete. Result: " + result);
        return result;
    }

    /**
     * Pros:
     * - Efficient level order traversal using a queue.
     * - Provides a clear and intuitive way to calculate averages for each level.
     *
     * Cons:
     * - Space usage can grow significantly for wide trees due to the queue storing all nodes at a level.
     * - Not optimized for trees with a very large number of nodes at certain levels.
     *
     * Use Cases:
     * - Analyzing tree structures (e.g., binary search trees, decision trees).
     * - Calculating level-wise aggregates for hierarchical data.
     * - Helpful in AI, such as when analyzing neural network architectures as trees.
     *
     * Space Complexity:
     * - O(w), where w is the maximum width of the tree (largest number of nodes at any level).
     *
     * Time Complexity:
     * - O(n), where n is the total number of nodes in the tree, since each node is visited exactly once.
     */
}
