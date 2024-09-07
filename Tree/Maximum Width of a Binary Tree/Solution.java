class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Deque<NodeWrapper> lotq = new ArrayDeque<>();
        lotq.add(new NodeWrapper(root, 0));
        while(!lotq.isEmpty()) {
            ans = Math.max(ans, lotq.getLast().ind - lotq.getFirst().ind + 1);

            int size = lotq.size();
            for(int i=0; i<size; i++) {
                NodeWrapper curr = lotq.poll();

                if(curr.node.left != null) {
                    lotq.add(new NodeWrapper(curr.node.left, (2*curr.ind) + 1));
                }

                if(curr.node.right != null) {
                    lotq.add(new NodeWrapper(curr.node.right, (2*curr.ind) + 2));
                }
            }
            
        }

        return ans;
    }

    class NodeWrapper {
        TreeNode node;
        int ind;

        NodeWrapper(TreeNode node, int ind) {
            this.node = node;
            this.ind = ind;
        }
    }
}