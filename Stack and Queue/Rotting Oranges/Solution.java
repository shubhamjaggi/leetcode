class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<String> bfsq=new ArrayDeque<>();
        int m=grid.length; int n=grid[0].length;
        int fresh=0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2) bfsq.add(i+","+j); // add all rotten oranges to bfsq
                else if(grid[i][j]==1) fresh++;
            }
        }

        int[][] dirs=new int[][] {{1,0},{-1,0},{0,1},{0,-1}};

        int level=0;
        while(!bfsq.isEmpty()) {
            int currLevelCount=bfsq.size();
            boolean shouldIncreaseBfsLevel=false;

            for(int i=0;i<currLevelCount;i++) {
                String[] curr=bfsq.poll().split(",");
                int r=Integer.valueOf(curr[0]); int c=Integer.valueOf(curr[1]);
                for(int[] dir:dirs) {
                    int nr=r+dir[0]; int nc=c+dir[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1) { // fresh orange found => to be converted to rotten
                        grid[nr][nc]=2;
                        fresh--;
                        bfsq.add(nr+","+nc); // add the rotten orange coordinates to bfsq => to be used in next level of bfs
                        shouldIncreaseBfsLevel=true;
                    }
                }
            }

            if(shouldIncreaseBfsLevel) level++;
        }

        return fresh==0?level:-1;
    }
}