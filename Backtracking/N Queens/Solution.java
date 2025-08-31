class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row, '.');

        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(char[][] board, int row, List<List<String>> result) {
        if(row==board.length) { // valid config found // base case of recursion
            result.add(getResultConfig(board));
            return;
        }

        for(int col=0; col<board.length; col++) { // try placing the queen at every square in the current row
            if(isSafe(board, row, col)) {
                board[row][col]='Q';
                backtrack(board, row+1, result);
                board[row][col]='.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        for(int i=row-1; i>=0; i--) { // check all squares above the current row in the current column
            if(board[i][col]=='Q') return false;
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) { // check all squares in the leftward diagonal moving up
            if(board[i][j]=='Q') return false;
        }

        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) { // check all squares in the rightward diagonal moving up
            if(board[i][j]=='Q') return false;
        }

        return true;
    }

    private List<String> getResultConfig(char[][] board) { // create (and return) board configuration in the required format
        List<String> config = new ArrayList<>();
        for(char[] row : board) config.add(String.valueOf(row));
        return config;
    }
}