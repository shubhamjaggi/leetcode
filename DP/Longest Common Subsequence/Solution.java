class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0; i<text1.length(); i++) Arrays.fill(dp[i], -1);
        return dp(text1, text2, 0, 0, dp);
    }

    private int dp(String text1, String text2, int i, int j, int[][] dp) {
        // characters match: add 1 to the result of the call of dp function for rest of the strings
        // charcters not match: max of the result of moving ahead only i pointer vs result of moving ahead only j pointer
        // if any of the strings has ended, we'll get zero out of that call

        if(i == text1.length() || j == text2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        if(text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j]=1+dp(text1, text2, i+1, j+1, dp);
        }
        
        return dp[i][j] = Math.max(dp(text1, text2, i, j+1, dp), dp(text1, text2, i+1, j, dp));
    }
}