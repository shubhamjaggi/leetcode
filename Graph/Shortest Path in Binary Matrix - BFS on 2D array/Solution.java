class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1; // edge case where source/dest cell is not 0
        if(n==1) return 1; // edge case with single cell

        Queue<int[]> bfsq=new ArrayDeque<>();
        boolean[][] vis=new boolean[n][n];
        bfsq.add(new int[]{0,0,1});
        vis[0][0]=true;

        int[][] dirs=new int[][] {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(!bfsq.isEmpty()) {
            int[] curr=bfsq.poll();
            int r=curr[0]; int c=curr[1]; int d=curr[2];
            for(int[] dir:dirs) {
                int nr=r+dir[0]; int nc=c+dir[1];
                if(nr>=0 && nc>=0 && nr<n && nc<n && !vis[nr][nc] && grid[nr][nc]==0) {
                    if(nr==n-1 && nc==n-1) return d+1; // reached dest
                    bfsq.add(new int[]{nr,nc,d+1});
                    vis[nr][nc]=true;
                }
            }
        }

        return -1;
    }
}