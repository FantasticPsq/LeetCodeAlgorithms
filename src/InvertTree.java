public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null){
            invertTree(root.left);
        }
        if(root.right!=null){
            invertTree(root.right);
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
