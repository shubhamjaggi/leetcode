class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int maxLength = Integer.MIN_VALUE;
        int startIndex = Integer.MIN_VALUE;

        for(int diff = 0; diff < s.length(); diff++){
            for(int i = 0, j = i + diff; j < s.length(); i++, j++){
                if(diff == 0){
                    dp[i][j] = 1;
                }
                else if(diff == 1){
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 0;
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0){
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] > maxLength){
                    maxLength = dp[i][j];
                    startIndex = i;
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }
}