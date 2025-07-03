class pathSum_Solution {
    public class TreeNode {
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

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int res=rootSum(root,targetSum);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;
    }

    private int rootSum(TreeNode node, int targetSum) {
        int ret=0;
        if(node==null) return 0;
        int val=node.val;
        if(val==targetSum)
        {
            ret++;
        }
        ret+=rootSum(node.left,targetSum-val);
        ret+=rootSum(node.right,targetSum-val);
        return ret;
    }

}

//public int pathSum(TreeNode root, long targetSum) {
//    if (root == null) {
//        return 0;
//    }
//
//    int ret = rootSum(root, targetSum);
//    ret += pathSum(root.left, targetSum);
//    ret += pathSum(root.right, targetSum);
//    return ret;
//}
//
//public int rootSum(TreeNode root, long targetSum) {
//    int ret = 0;
//
//    if (root == null) {
//        return 0;
//    }
//    int val = root.val;
//    if (val == targetSum) {
//        ret++;
//    }
//
//    ret += rootSum(root.left, targetSum - val);
//    ret += rootSum(root.right, targetSum - val);
//    return ret;
//}