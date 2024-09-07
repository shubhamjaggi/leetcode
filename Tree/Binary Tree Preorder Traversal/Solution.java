class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        buildPreorder(root, ans);
        return ans;
    }

    private void buildPreorder(TreeNode node, List<Integer> vals) {
        if(node==null) return;
        vals.add(node.val);
        buildPreorder(node.left, vals);
        buildPreorder(node.right, vals);
    }
}