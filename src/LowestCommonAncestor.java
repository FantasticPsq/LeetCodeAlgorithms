public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((root.val>p.val&&root.val<q.val)||(root.val<p.val&&root.val>q.val)){
            return root;
        }
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        if(p.val==root.val||q.val==root.val){
            return root;
        }
        return null;
    }
}
