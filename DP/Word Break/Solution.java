class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true; // consider "empty string can be segmented" // dp[n] returns whether prefix (of s) of length n can be segmented or not
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] && words.contains(s.substring(j,i))) {
                    // if prefix of s (using j chars) is segmentable and substring (of length i-j) after the prefix is a word in the dictionary
                    dp[i]=true; break;
                }
            }
        }
        return dp[s.length()];
    }
}