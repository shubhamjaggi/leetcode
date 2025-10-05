class Solution {
    int[][] dirs=new int[][] {{0,1},{1,0},{0,-1},{-1,0}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans=new ArrayList<>();
        Trie trie=buildTrie(words);
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(i,j,board,trie,ans);
            }
        }
        return ans;
    }

    private void dfs(int i, int j, char[][] board, Trie trie, List<String> ans) {
        char ch=board[i][j]; int m=board.length; int n=board[0].length;
        if(ch=='#' || trie.next[ch-'a']==null) return; // continue DFS only if "current cell is not visited" and "trie's next level has current cell char"
        
        trie=trie.next[ch-'a']; // update trie for next level dfs
        if(trie.word!=null) { // word found
            ans.add(trie.word); // update answer list
            trie.word=null; // avoid duplicate words
        }
        board[i][j]='#'; // mark visited to avoid duplicate dfs calls
        for(int[] dir:dirs) {
            int nr=i+dir[0]; int nc=j+dir[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n) dfs(nr,nc,board,trie,ans);
        }
        board[i][j]=ch; // backtrack
    }

    private Trie buildTrie(String[] words) {
        Trie root=new Trie();
        for(String word:words) {
            Trie curr=root;
            for(char ch:word.toCharArray()) {
                if(curr.next[ch-'a']==null) curr.next[ch-'a']=new Trie();
                curr=curr.next[ch-'a'];
            }
            curr.word=word;
        }
        return root;
    }
}

class Trie {
    Trie[] next=new Trie[26];
    String word;
}