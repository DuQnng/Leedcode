import java.util.LinkedList;
import java.util.Queue;

public class buildTreeWithPreorderInorder {

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
    public void flatten(TreeNode root) {
        if(root==null) return;
        Queue<Integer> Tree_list = new LinkedList<Integer>();
        inorder(root, Tree_list);
        root.left=null;
        Tree_list.poll();
        buildTree(root,Tree_list);
    }

    private void buildTree(TreeNode node, Queue<Integer> Tree_list) {
        if(Tree_list.isEmpty()) return;
        TreeNode new_tree=new TreeNode();
        new_tree.val=Tree_list.poll();
        node.right=new_tree;
        buildTree(node.right,Tree_list);
    }

    public void inorder(TreeNode node, Queue<Integer> res) {
        if(node==null) return;
        res.offer(node.val);
        inorder(node.left,res);
        inorder(node.right,res);
    }




}
