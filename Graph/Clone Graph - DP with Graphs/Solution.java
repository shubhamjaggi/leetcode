class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        return cloneWithDp(node, new HashMap<>());
    }

    public Node cloneWithDp(Node node, Map<Node,Node> dp) {
        if(dp.containsKey(node)) return dp.get(node);

        Node newNode=new Node(node.val);
        dp.put(node,newNode);
        
        for(Node nei:node.neighbors) {
            Node neiClone=cloneWithDp(nei,dp);
            newNode.neighbors.add(neiClone);
        }

        // dp.put(node,newNode) here (instead of above) will not work due to infinite recursion calls
        return newNode;
    }
}