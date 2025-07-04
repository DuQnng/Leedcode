public class sortedArrayToBST {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return trail(nums,0,nums.length-1);
    }
    public TreeNode trail(int[] nums,int left,int right)
    {
        if(left>right) return  null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=trail(nums,left,mid-1);
        root.right=trail(nums,mid+1,right);
        return root;

    }
}
