package problems.binary_tree_bfs.binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewSolution {
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
        BinaryTreeRightSideViewSolution binaryTreeRightSideViewSolution = new BinaryTreeRightSideViewSolution();

        // root = [1,2,3,null,5,null,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        // Calculating the average of levels
        List<Integer> result = binaryTreeRightSideViewSolution.rightSideView(root);
        System.out.println("result: " + result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}

