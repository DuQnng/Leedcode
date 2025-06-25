import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

class maxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        int ans=0;
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size=queue.size();
            while (size>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
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

}