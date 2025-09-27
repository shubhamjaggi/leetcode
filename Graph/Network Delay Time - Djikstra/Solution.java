class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create adjacency list
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge: times) {
            int u=edge[0]; int v=edge[1]; int w=edge[2];
            adj.get(u-1).add(new Node(v-1,w)); // Here, Node constructor's 2nd argument is for weight for the specific edge.
            // subtracted 1 because values are from 1 to n
        }
        
        boolean[] vis = new boolean[n];
        int[] dist = new int[n]; // for storing min dist from source
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::d));
        dist[k-1]=0;
        pq.add(new Node(k-1,0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int u=curr.val;

            if(vis[u]) continue;
            vis[u]=true;

            for(Node nei:adj.get(u)) {
                int v=nei.val;
                int d=nei.d;
                if(dist[u]+d<dist[v]) {
                    dist[v]=dist[u]+d;
                    pq.add(new Node(v,dist[v])); // Here, Node constructor's 2nd argument is for min dist from source
                }
            }
        }

        int max=0;
        for(int d:dist) {
            if(d==Integer.MAX_VALUE) return -1;
            max=Math.max(max,d);
        }

        return max;
    }
}

class Node {
    int val;
    int d;

    Node(int val, int d) {
        this.val=val;
        this.d=d;
    }

    int d() {
        return this.d;
    }
}