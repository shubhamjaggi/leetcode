class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)), height(root.left)+height(root.right));
    }

    private int height(TreeNode node) {
        if(node==null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}