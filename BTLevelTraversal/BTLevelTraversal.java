public class BTLevelTraversal {
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return list;
        }
        inorderWithLevel(root, 0, list);
        return list;
    }
    
    private void inorderWithLevel(TreeNode node, int level, ArrayList<ArrayList<Integer>> list){
        if (node == null) {
            return;
        } 
        if (list.size() < (level + 1)){
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            list.add(innerList);
        }
        inorderWithLevel(node.left, level+1, list);
        ArrayList<Integer> tmpList = (ArrayList<Integer>)list.get(level);
        tmpList.add(node.val);        
        inorderWithLevel(node.right, level+1, list);
    }
}
