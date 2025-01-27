package problems.binary_tree_bfs.minimum_absolute_difference_bst;

public class MinimumAbsoluteDifferenceBSTPractice {
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
        MinimumAbsoluteDifferenceBSTPractice minimumAbsoluteDifferenceBSTPractice = new MinimumAbsoluteDifferenceBSTPractice();

        // Create test tree: root = [4,2,6,1,3]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);

        // Get result and print it
        int result = minimumAbsoluteDifferenceBSTPractice.getMinimumDifference(root);
        System.out.println("Result: " + result); // Log final result
    }

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root){
        if(root==null){
            return min;
        }
        getMinimumDifference(root.left);
        if(prev!=null){
            min=Math.min(min, root.val-prev);
        }
        prev=root.val;
        getMinimumDifference(root.right);
        return min;
    }
}
