class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie=buildTrie(dictionary);
        String[] words=sentence.split("\\s");
        StringBuilder sb=new StringBuilder();
        for(String word:words) {
            sb.append(" "); sb.append(getShortestRoot(word,trie));
        }

        return sb.toString().trim();
    }

    private Trie buildTrie(List<String> roots) {
        Trie trie=new Trie();
        for(String root:roots) {
            Trie curr=trie;
            for(char ch:root.toCharArray()) {
                if(curr.next[ch-'a']==null) curr.next[ch-'a']=new Trie();
                curr=curr.next[ch-'a'];
            }
            curr.root=root;
        }
        return trie;
    }

    private String getShortestRoot(String word, Trie trie) {
        Trie curr=trie;
        for(char ch:word.toCharArray()) {
            if(curr.root!=null) return curr.root;
            if(curr.next[ch-'a']==null) return word;
            curr=curr.next[ch-'a'];
        }
        return word;
    }
}

class Trie {
    Trie[] next=new Trie[26];
    String root;
}