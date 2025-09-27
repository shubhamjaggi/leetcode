class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] par=new int[edges.length+1];
        // added 1 to make retrieval more readable (as nodes are from 1 to n)

        for(int i=0; i<par.length; i++) par[i]=i;

        int[] ans=edges[0];

        for(int[] edge:edges) {
            int u=edge[0]; int v=edge[1];
            int repU=rep(par,u);
            int repV=rep(par,v);

            if(repU==repV) {
                ans=edge;
            } else {
                par[repU]=repV; // perform union
            }
        }

        return ans;
    }

    private int rep(int[] par, int x) {
        while(par[x]!=x) x=par[x];
        return x;
    }
}