package problems.binary_tree_bfs.binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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
        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();

        // root = [1,2,3,null,5,null,4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        List<Integer> result = binaryTreeRightSideView.rightSideView(root);
        System.out.println("result: " + result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            result.add(node.val);
            if(node.right != null){
                q.offer(node.right);
            }else if(node.left != null){
                q.offer(node.left);
            }else{
                q.offer((root.left));
            }

        }
        return result;
    }
}
