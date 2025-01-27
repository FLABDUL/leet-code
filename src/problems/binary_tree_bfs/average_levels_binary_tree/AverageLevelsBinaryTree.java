//package problems.binary_tree_bfs.average_levels_binary_tree;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AverageLevelsBinaryTree {
//     public static class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//     }
//
//    public static void main(String[] args) {
//        AverageLevelsBinaryTree averageLevelsBinaryTree = new AverageLevelsBinaryTree();
//        TreeNode root = new TreeNode();
//        root.val = 3;
//        root.left.val = 9;
//        root.right.val = 20;
//        root.right.left.val = 15;
//        root.right.right.val = 7;
//        System.out.println("result: " + averageLevelsBinaryTree.averageOfLevels(root));
//    }
//
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double> result = new ArrayList<>();
//        result.add((double) root.val);
//        int sum = 0;
//        double average = 0;
//        while(root.left != null | root.right != null) {
//            if (root.left != null) {
//                sum += root.left.val;
//            }
//            if (root.right != null) {
//                sum += root.right.val;
//            }
//            average = (double) sum / 2;
//            result.add(average);
//        }
//    }
//}
