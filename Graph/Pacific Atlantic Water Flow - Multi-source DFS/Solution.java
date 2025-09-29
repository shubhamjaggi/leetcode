class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length; int n=heights[0].length;

        boolean[][] pacific = new boolean[m][n]; // visited array for pacific
        boolean[][] atlantic = new boolean[m][n]; // visited array for atlantic

        // move from edge cells towards inner cells

        for(int j=0; j<n; j++) dfs(heights,0,j,pacific); // DFS for pacific from top edge
        for(int i=0; i<m; i++) dfs(heights,i,0,pacific); // DFS for pacific from left edge

        for(int i=0; i<m; i++) dfs(heights,i,n-1,atlantic); // DFS for atlantic from right edge
        for(int j=0; j<n; j++) dfs(heights,m-1,j,atlantic); // DFS for atlantic from bottom edge

        // build result
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i,j));
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] visited) {
        visited[i][j]=true;
        int m=heights.length; int n=heights[0].length;

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] dir:directions) {
            int nextRow=i+dir[0]; int nextCol=j+dir[1];
            if(nextRow>=0 && nextRow<m && nextCol>=0 && nextCol<n) {
                if(!visited[nextRow][nextCol] && heights[nextRow][nextCol]>=heights[i][j]) {
                    dfs(heights,nextRow,nextCol,visited);
                }
            }
        }
    }
}