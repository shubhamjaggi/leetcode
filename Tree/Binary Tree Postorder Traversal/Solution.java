class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        buildPostorder(root, ans);
        return ans;
    }

    private void buildPostorder(TreeNode node, List<Integer> vals) {
        if(node==null) return;
        buildPostorder(node.left, vals);
        buildPostorder(node.right, vals);
        vals.add(node.val);
    }
}