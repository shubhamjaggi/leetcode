class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Bellman-Ford algorithm: x iterations => gives shortest distances from source using at most x edges
        // at most k stops => at most k+1 edges => k+1 iterations of Bellman Ford algo

        int[] dist=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src]=0;

        for(int i=0; i<k+1; i++) {
            int[] distPrev=dist.clone();
            // this cloning can be used in standard bellman ford algo as well but makes the standard algo less efficient
            // in this problem, we need it to satisfy the edge count constraints
            
            for(int[] flight:flights) {
                int u=flight[0]; int v=flight[1]; int cost=flight[2];
                if(distPrev[u]!=Integer.MAX_VALUE) dist[v]=Math.min(dist[v],distPrev[u]+cost);
            }
        }
        
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}