public class isValidBST {
    public static void main(String[] args) {
        TreeNode left=new TreeNode(1);
        TreeNode Tree=new TreeNode(1,left,null);


    }
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
    public boolean isValidBST(TreeNode root) {
        return is(root,Long.MAX_VALUE,Long.MAX_VALUE);
    }
    public boolean is(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return is(node.left, lower, node.val) && is(node.right,node.val, upper);
    }
}
