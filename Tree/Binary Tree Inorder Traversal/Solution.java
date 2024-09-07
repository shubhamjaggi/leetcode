class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        buildInorder(root, ans);
        return ans;
    }

    private void buildInorder(TreeNode node, List<Integer> vals) {
        if(node==null) return;
        buildInorder(node.left, vals);
        vals.add(node.val);
        buildInorder(node.right, vals);
    }
}