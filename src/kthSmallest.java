import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class kthSmallest {
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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res.get(k-1);
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if(node==null)
        {
            return ;
        }
        inorder(node.left,res);
        res.add(node.val);
        inorder(node.right,res);
    }


}
