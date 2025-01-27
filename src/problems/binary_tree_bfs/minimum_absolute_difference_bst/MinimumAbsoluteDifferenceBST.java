package problems.binary_tree_bfs.minimum_absolute_difference_bst;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumAbsoluteDifferenceBST {
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
        MinimumAbsoluteDifferenceBST minimumAbsoluteDifferenceBST = new MinimumAbsoluteDifferenceBST();

//        root = [4,2,6,1,3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        int result = minimumAbsoluteDifferenceBST.getMinimumDifference(root);
        System.out.println("result: " + result);
    }

    public int getMinimumDifference(TreeNode root) {
        int mad = 0;
        Set<Integer> values = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return 0;
        }
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                TreeNode node = q.poll();
                values.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                    values.add(node.left.val);
                }
                if(node.right!=null){
                    q.offer(node.right);
                    values.add(node.right.val);
                }
            }
        }
        for(int value : values){

        }

        return 0;
    }
}
