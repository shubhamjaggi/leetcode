class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]=='1') {
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i==-1 || i==grid.length || j==-1 || j==grid[0].length) return;
        if(grid[i][j]!='1') return;

        grid[i][j]='0'; // marked visited

        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}