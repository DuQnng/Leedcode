import java.util.*;

public class levelOrder {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null)
        {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size=queue.size();
            List<Integer> cur=new ArrayList<Integer>();
            while (size>0)
            {
                TreeNode node=queue.poll();
                cur.add(node.val);
                if(node.left!=null)
                {
                    queue.offer(node.left);
                }
                if (node.right!=null)
                {
                    queue.offer(node.right);
                }
                size--;
            }
            result.add(cur);
        }
        return result;
    }
}
