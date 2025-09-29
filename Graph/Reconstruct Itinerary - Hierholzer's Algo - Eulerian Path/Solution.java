class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,Queue<String>> adj=new HashMap<>(); // works similar to standard graph adjacency list
        for(List<String> ticket:tickets) {
            String from=ticket.get(0); String to=ticket.get(1);
            adj.computeIfAbsent(from,k->new PriorityQueue<String>()).add(to); // PQ ensures the required string ordering in the result
        }

        Stack<String> topoStack=new Stack<>();
        dfs("JFK",adj,topoStack);

        List<String> ans=new ArrayList<>();
        while(!topoStack.isEmpty()) ans.add(topoStack.pop());
        return ans;
    }

    private void dfs(String from, Map<String,Queue<String>> adj, Stack<String> topoStack) {
        while(adj.get(from)!=null && !adj.get(from).isEmpty()) { // while loop to check the remaining neighbors to call DFS on them
            dfs(adj.get(from).poll(),adj,topoStack); // polling works in a similar way as marking visited in standard graph DFS
        }
        topoStack.push(from); // same as stack in DFS based topological sort
    }
}