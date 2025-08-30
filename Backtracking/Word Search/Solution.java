class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length; int n=board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(isPossible(i, j, 0, word, board)) return true;
            }
        }
        return false;
    }

    private boolean isPossible(int i, int j, int charInd, String word, char[][] board) {
        if(charInd==word.length()) return true;
        if(i==board.length || j==board[0].length || i<0 || j<0 || board[i][j]=='1') return false;

        if(word.charAt(charInd)==board[i][j]) {
            char letter = board[i][j];
            board[i][j]='1'; // marking as visited

            boolean res = isPossible(i+1, j, charInd+1, word, board)
                    || isPossible(i, j+1, charInd+1, word, board)
                    || isPossible(i-1, j, charInd+1, word, board)
                    || isPossible(i, j-1, charInd+1, word, board);
            
        
            board[i][j]=letter; // backtrack
            return res;
        }
        return false;
    }
}