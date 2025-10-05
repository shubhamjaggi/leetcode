class Trie {
    private Trie[] nextChars;
    private boolean isEnd;

    public Trie() {
        this.nextChars=new Trie[26];
        this.isEnd=false;
    }
    
    public void insert(String word) {
        Trie curr=this;
        for(char ch:word.toCharArray()) {
            if(curr.nextChars[ch-'a']==null) {
                curr.nextChars[ch-'a']=new Trie();
            }
            curr=curr.nextChars[ch-'a'];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        Trie curr=this;
        for(char ch:word.toCharArray()) {
            if(curr.nextChars[ch-'a']==null) return false;
            curr=curr.nextChars[ch-'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie curr=this;
        for(char ch:prefix.toCharArray()) {
            if(curr.nextChars[ch-'a']==null) return false;
            curr=curr.nextChars[ch-'a'];
        }
        return true;
    }
}