public class isSymmetric {
    public class TreeNode {
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compare(root.left,root.right);
    }
    public boolean compare(TreeNode left,TreeNode right){
        if(left==null&&right!=null) return false;
        if(left!=null&&right==null) return false;
        if (left==null&&right==null) return true;
        if (left.val!=right.val) return false;
        boolean outside=compare(left.left,right.right);
        boolean inside=compare(right.left,left.right);
        boolean result=outside&&inside;
        return result;
    }
}
