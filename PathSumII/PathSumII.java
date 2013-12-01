public class PathSumII {
     public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> pathlist = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        pathlist.add(root.val);
        findPathSum(root, sum, list, pathlist);
        return list;
    }
    
    private void findPathSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> pathlist) {
        if (isLeaf(node)) {
            int total = 0;
            for (Integer num: pathlist) {
                total += num;
            }
            if (total == sum) {
                ArrayList<Integer> newPath = (ArrayList<Integer>)pathlist.clone();
                list.add(newPath);
            }
            return;
        }
        
        if (node.left != null) {
            pathlist.add(node.left.val);
            findPathSum(node.left, sum, list, pathlist);
            pathlist.remove(pathlist.size() - 1);
        }
        if (node.right != null) {
            pathlist.add(node.right.val);
            findPathSum(node.right, sum, list, pathlist);
            pathlist.remove(pathlist.size() - 1);
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        if ((node.left == null) && (node.right == null)) {
            return true;
        }
        return false;
    }
}
