class WordDictionary {
    private Trie trie;

    public WordDictionary() {
        this.trie=new Trie();
    }
    
    public void addWord(String word) {
        this.trie.insert(word);
    }
    
    public boolean search(String word) {
        return this.trie.isPresent(word,0);
    }
}

class Trie {
    private Trie[] next;
    private boolean isEnd;

    Trie() {
        this.next=new Trie[26];
        this.isEnd=false;
    }

    void insert(String word) {
        Trie curr=this;
        for(char ch:word.toCharArray()) {
            if(curr.next[ch-'a']==null) curr.next[ch-'a']=new Trie();
            curr=curr.next[ch-'a'];
        }
        curr.isEnd=true;
    }

    boolean isPresent(String word, int start) {
        Trie curr=this;
        for(int i=start;i<word.length();i++) {
            char ch=word.charAt(i);
            if(ch=='.') {
                for(Trie next:curr.next) { // check for the rest of the word in all of the Trie instances that are next to the current '.' character
                    if(next!=null && next.isPresent(word,i+1)) return true; // use i+1 to check only for the rest of the word
                }
                return false;
            } else if(curr.next[ch-'a']==null) return false;
            curr=curr.next[ch-'a'];
        }
        return curr.isEnd;
    }
}