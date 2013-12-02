public class MaximumDepthBT {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findHeight(root);
        
    }
    
    private int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findHeight(node.left);
        int right = findHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
