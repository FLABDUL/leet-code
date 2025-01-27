package problems.binary_tree_bfs.binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewLog {
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
        BinaryTreeRightSideViewLog binaryTreeRightSideViewLog = new BinaryTreeRightSideViewLog();

        // Example tree: root = [1,2,3,null,5,null,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        // Calculating the right side view of the tree
        List<Integer> result = binaryTreeRightSideViewLog.rightSideView(root);
        System.out.println("Right Side View: " + result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        System.out.println("Starting computation of the right-side view.");
        rightView(root, result, 0);
        System.out.println("Finished computation of the right-side view.");
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            System.out.println("Hit a null node at depth " + currDepth + ". Returning.");
            return; // Base case: return when reaching a null node
        }

        System.out.println("Visiting node with value " + curr.val + " at depth " + currDepth);

        if (currDepth == result.size()) {
            System.out.println("Adding node value " + curr.val + " to the result as the first node at depth " + currDepth);
            result.add(curr.val); // Add the first node value encountered at this depth
        }

        // Recursive call: first explore the right subtree
        System.out.println("Exploring the right child of node " + curr.val);
        rightView(curr.right, result, currDepth + 1);

        // Recursive call: then explore the left subtree
        System.out.println("Exploring the left child of node " + curr.val);
        rightView(curr.left, result, currDepth + 1);
    }
}

/*
PROS:
1. Simple and intuitive recursive approach for traversing the tree.
2. Captures the rightmost view efficiently by prioritizing the right subtree.

CONS:
1. Recursion can lead to stack overflow for very deep trees (when the tree is highly unbalanced).
2. Space complexity is not optimal due to recursion stack overhead.

USES:
1. Visualizing the "rightmost view" of a binary tree for graphical representations.
2. Useful in tree-based problems where we need to extract layer-specific or path-specific information.

SPACE COMPLEXITY:
- O(H): where H is the height of the tree. This is due to the recursion stack.

TIME COMPLEXITY:
- O(N): where N is the number of nodes in the binary tree. Every node is visited once.

RELATION TO ALGORITHMS:
This solution is based on Depth-First Search (DFS). It uses recursion to traverse the tree, prioritizing the right subtree first.
- The method ensures that the first node encountered at each depth (via right-priority traversal) is added to the result.
- This is a variation of preorder traversal (visit root, then children) with a **right-to-left priority**.

WHY DFS IS A GOOD FIT:
1. **Efficient for right-side view**: By visiting the right subtree first, unnecessary nodes are avoided for this specific problem.
2. **Recursive simplicity**: The recursive approach is concise and leverages the call stack to maintain the traversal state.

HOW IT DIFFERS FROM BFS:
- A BFS approach (using a queue) could solve this too, but it would process all nodes at a level, requiring more space for storing nodes.

 */
