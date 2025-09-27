class Solution {
    public int[] findOrder(int numCourses, int[][] prq) {
        // create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int[] revEdge:prq) {
            int u=revEdge[1]; int v=revEdge[0];
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];
        Stack<Integer> topoStack = new Stack<>();

        for(int i=0; i<numCourses; i++) {
            if(!vis[i]) {
                if(dfs(adj,i,vis,rec,topoStack)) return new int[0];
            }
        }
        
        int ans[] = new int[numCourses];
        int ind=0;
        while(!topoStack.isEmpty()) ans[ind++]=topoStack.pop();

        return ans;
    }

    private boolean dfs(List<List<Integer>> adj, int i, boolean[] vis, boolean[] rec, Stack<Integer> topoStack) {
        vis[i]=true;
        rec[i]=true;

        for(int nei:adj.get(i)) {
            if(!vis[nei]) {
                if(dfs(adj,nei,vis,rec,topoStack)) return true;
            } else if(rec[nei]) return true;
        }

        rec[i]=false;
        topoStack.push(i);

        return false;
    }
}