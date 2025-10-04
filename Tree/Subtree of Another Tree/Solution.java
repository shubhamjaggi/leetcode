class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return subRoot==null;
        if(root.val==subRoot.val && isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right)) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2==null;
        if(root2==null) return root1==null;
        
        return root1.val==root2.val && isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
    }
}