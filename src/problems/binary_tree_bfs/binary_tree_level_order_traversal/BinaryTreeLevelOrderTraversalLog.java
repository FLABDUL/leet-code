package problems.binary_tree_bfs.binary_tree_level_order_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalLog {
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
        BinaryTreeLevelOrderTraversalLog binaryTreeLevelOrderTraversalLog = new BinaryTreeLevelOrderTraversalLog();

        // Example Tree: root = [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        System.out.println("Starting level order traversal...");
        List<List<Integer>> result = binaryTreeLevelOrderTraversalLog.levelOrder(root);
        System.out.println("Final result: " + result);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Queue to help with BFS traversal
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // Wrap list to store the final level order traversal result
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if (root == null) {
            System.out.println("The tree is empty. Returning an empty list.");
            return wrapList; // Return empty list if root is null
        }

        System.out.println("Adding root node with value: " + root.val);
        queue.offer(root); // Add root node to the queue

        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // Number of nodes in the current level
            System.out.println("Processing a new level with " + levelNum + " nodes.");

            List<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode currentNode = queue.peek();
                System.out.println("Visiting node with value: " + currentNode.val);

                // Add left child if exists
                if (currentNode.left != null) {
                    System.out.println("Adding left child with value: " + currentNode.left.val);
                    queue.offer(currentNode.left);
                }

                // Add right child if exists
                if (currentNode.right != null) {
                    System.out.println("Adding right child with value: " + currentNode.right.val);
                    queue.offer(currentNode.right);
                }

                subList.add(queue.poll().val); // Add the node value and remove it from the queue
            }
            System.out.println("Completed level: " + subList);
            wrapList.add(subList); // Add the current level to the wrap list
        }

        return wrapList;
    }

    // Known Algorithm: Breadth-First Search (BFS)
    // This approach leverages BFS to traverse the tree level by level using a queue.

    // Pros:
    // - Straightforward implementation for level order traversal.
    // - Efficient use of memory for breadth-first traversal.
    // - Preserves the structure of levels, which is helpful for many applications.

    // Cons:
    // - Can use significant memory if the tree is wide (large number of nodes at a level).
    // - Relatively slower than Depth-First Search (DFS) for deeply nested trees due to queue overhead.

    // Use Cases:
    // - When the structure of levels in a tree matters (e.g., zigzag traversal, finding deepest nodes).
    // - Problem-solving involving hierarchical or breadth-based relationships.

    // Space Complexity: O(n)
    // - Space is required for the queue, which in the worst case (a complete binary tree) holds all nodes in the last level (~n/2 nodes).

    // Time Complexity: O(n)
    // - Each node is visited once, resulting in linear time complexity relative to the number of nodes.
}
