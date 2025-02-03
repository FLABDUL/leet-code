package wise;

public class LowestCommonAncestor {
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left  = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println("result: " + lowestCommonAncestor.lowestCommonAncestor(root, root.left, root.right));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){//if top then has to include both
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);//check left tree
        TreeNode right = lowestCommonAncestor(root.right, p, q);//then right
        return left == null ? right : right == null ? left : root;//if end left, go right, same check, if not root
    }
}
