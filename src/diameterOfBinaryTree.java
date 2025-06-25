
import java.util.ArrayList;
import java.util.List;

public class diameterOfBinaryTree {
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
    int max_res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max_res;

    }

    private int depth(TreeNode node) {
        if(node==null) return 0;
        int left=depth(node.left);
        int right=depth(node.right);
        max_res=Math.max(max_res,left+right);
        return Math.max(left,right)+1;
    }
}
