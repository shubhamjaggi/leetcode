class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> bfsq=new ArrayDeque<>();
        if(root!=null) bfsq.add(root);
        while(!bfsq.isEmpty()) {
            int size=bfsq.size();
            List<Integer> levelNodes=new ArrayList<>(); ans.add(levelNodes);
            for(int i=0;i<size;i++) {
                TreeNode curr=bfsq.poll();
                levelNodes.add(curr.val);
                if(curr.left!=null) bfsq.add(curr.left);
                if(curr.right!=null) bfsq.add(curr.right);
            }
        }
        return ans;
    }
}