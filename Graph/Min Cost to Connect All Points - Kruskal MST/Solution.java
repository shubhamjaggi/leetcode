class Solution {
    public int minCostConnectPoints(int[][] points) {
        // generate edges using points
        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<points.length-1; i++) {
            for(int j=i+1; j<points.length; j++) {
                int ux=points[i][0];
                int uy=points[i][1];
                int vx=points[j][0];
                int vy=points[j][1];

                int cost=Math.abs(ux-vx)+Math.abs(uy-vy);
                edges.add(new Edge(coord(ux,uy),coord(vx,vy),cost));
            }
        }

        // sort the edges
        Collections.sort(edges,Comparator.comparing(Edge::cost));

        int unionsLeft=points.length-1; // to do exactly V-1 unions

        // populate parent array with defaults
        Map<String,String> par = new HashMap<>();
        for(int[] point:points) {
            String val=coord(point[0],point[1]);
            par.put(val,val);
        }

        int ans=0;

        for(Edge edge:edges) {
            if(unionsLeft==0) break;
            String repU=rep(par,edge.u);
            String repV=rep(par,edge.v);

            if(!repU.equals(repV)) {
                ans+=edge.cost; // update answer variable
                unionsLeft--;
                par.put(repU,repV); // perform union operation
            }
        }

        return ans;
    }

    private String coord(int x, int y) { return x+","+y; }

    private String rep(Map<String,String> par, String x) {
        while(par.get(x)!=x) x=par.get(x);
        return x;
    }
}

class Edge {
    String u;
    String v;
    int cost;

    Edge(String u, String v, int cost) {
        this.u=u;
        this.v=v;
        this.cost=cost;
    }

    int cost() {
        return this.cost;
    }
}