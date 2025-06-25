
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CinorderTraversal {
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
    public TreeNode invertTree(TreeNode cur) {
        if(cur==null){
            return cur;
        }
        TreeNode left =invertTree(cur.left);
        TreeNode right=invertTree(cur.right);
        cur.left=right;
        cur.right=left;
        return cur;
    }
}
