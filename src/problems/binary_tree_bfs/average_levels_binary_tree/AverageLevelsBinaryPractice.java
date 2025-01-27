package problems.binary_tree_bfs.average_levels_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryPractice {
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
        AverageLevelsBinaryPractice averageLevelsBinaryTreePractice = new AverageLevelsBinaryPractice();

        // Creating the tree structure as described in the input [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Calculating the average of levels
        List<Double> result = averageLevelsBinaryTreePractice.averageOfLevels(root);
        System.out.println("result: " + result);
    }

    public List<Double> averageOfLevels(TreeNode root){
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i<n; i++){
                TreeNode node = q.poll();
                sum+= node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            result.add(sum/n);
        }
        return result;
    }
}
