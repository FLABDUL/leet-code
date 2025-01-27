//package problems.binary_tree_bfs.binary_tree_level_order_traversal;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BinaryTreeLevelOrderTraversal {
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode() {
//        }
//        TreeNode(int val) {
//            this.val = val;
//        }
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    public static void main(String[] args) {
//        BinaryTreeLevelOrderTraversal BinaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
//
//        // root = [3,9,20,null,null,15,7]
//        BinaryTreeLevelOrderTraversal.TreeNode root = new BinaryTreeLevelOrderTraversal.TreeNode(3);
//        root.left = new BinaryTreeLevelOrderTraversal.TreeNode(9);
//        root.right = new BinaryTreeLevelOrderTraversal.TreeNode(20);
//        root.right.right = new BinaryTreeLevelOrderTraversal.TreeNode(7);
//        root.right.left = new BinaryTreeLevelOrderTraversal.TreeNode(15);
//
//        List<List<Integer>> result = BinaryTreeLevelOrderTraversal.levelOrder(root);
//        System.out.println("result: " + result);
//    }
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        level(root, result, 0);
//
//
//
//        return result;
//    }
//
//    public List<Integer> level(TreeNode currentRoot, List<List<Integer>> result, int currentDepth){
//        if(currentRoot==null){
//            return List.of();
//        }
//        List<Integer> levelResult = new ArrayList<>();
//        if(currentDepth==result.size()){
//
//            levelResult.add(currentRoot.left.val);
//            levelResult.add(currentRoot.right.val);
//            result.add(levelResult);
//        }
//
//        level(currentRoot.left, levelResult, currentDepth+1)
//    }
//}
