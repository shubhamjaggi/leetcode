class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val) return lowestCommonAncestor(root.left,p,q); // both in left subtree
        else if(p.val>root.val && q.val>root.val) return lowestCommonAncestor(root.right,p,q); // both in right subtree
        else return root;
    }
}