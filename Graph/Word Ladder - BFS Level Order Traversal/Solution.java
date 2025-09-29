class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary=new HashSet<>(wordList);
        Queue<String> bfsQueue=new ArrayDeque<>();

        bfsQueue.add(beginWord);
        dictionary.remove(beginWord); // mark visited

        int level=1;
        
        while(!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for(int i=0;i<size;i++) { // process all words in the current level
                String word=bfsQueue.poll();
                if(word.equals(endWord)) return level;
                addWordsForNextLevel(word, bfsQueue, dictionary);
            }
            level++;
        }

        return 0;
    }

    private void addWordsForNextLevel(String word, Queue<String> bfsQueue, Set<String> dictionary) {
            char[] wordChars=word.toCharArray();
            for(int j=0;j<word.length();j++) { // try all the different chars (a-z) at every position of the current word
                char origChar=word.charAt(j);
                
                for(char ch='a';ch<='z';ch++) {
                    if(ch==origChar) continue;
                    wordChars[j]=ch;
                    String newWord=new String(wordChars);

                    if(dictionary.contains(newWord)) {
                        bfsQueue.add(newWord);
                        dictionary.remove(newWord); // mark visited
                    }
                }
                wordChars[j]=origChar;
            }
    }
}