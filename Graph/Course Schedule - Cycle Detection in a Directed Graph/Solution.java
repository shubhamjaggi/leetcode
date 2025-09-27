class Solution {
    public boolean canFinish(int numCourses, int[][] prq) {
        List<List<Integer>> adj = new ArrayList<>();

        // create adjacency list
        for(int i=0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int i=0; i<prq.length; i++) adj.get(prq[i][1]).add(prq[i][0]);

        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];

        for(int i=0; i<numCourses; i++) {
            if(!vis[i]) {
                if(dfs(adj,vis,i,rec)) return false;
            }
        }

        return true;
    }

    // this returns true if cycle is present i.e. if all courses can't be completed
    private boolean dfs(List<List<Integer>> adj, boolean[] vis, int i, boolean[] rec) {
        vis[i]=true;
        rec[i]=true;
        for(int nei:adj.get(i)) {
            if(!vis[nei]) {
                if(dfs(adj,vis,nei,rec)) return true;
            } else if(rec[nei]) {
                return true;
            }
        }
        rec[i]=false;
        return false;
    }
}