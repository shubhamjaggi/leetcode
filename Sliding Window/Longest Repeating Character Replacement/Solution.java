class Solution {
    public int characterReplacement(String s, int k) {
        int left=0, right=0, ans=0, n=s.length();

        Map<Character,Integer> countMap = new HashMap<>();
        for(char i='A'; i<='Z'; i++) countMap.put(i,0);

        int maxFreq=0;

        while(right<n) {
            char rightCh=s.charAt(right);
            countMap.put(rightCh, countMap.get(rightCh)+1);
            maxFreq=Math.max(maxFreq,countMap.get(rightCh));

            while(!isValidWindow(left,right,maxFreq,k)) {
                char leftCh=s.charAt(left);
                Integer leftChFreq=countMap.get(leftCh);
                countMap.put(leftCh, leftChFreq-1);
                left++;
            }

            // After the above while loop completes, we reach a valid window.
            // So, update ans if required.

            int currWindowLength=right-left+1;
            ans=Math.max(ans,currWindowLength);
            right++;
        }

        return ans;
    }

    private boolean isValidWindow(int left, int right, int maxFreq, int k) {
        int windowLength=(right-left)+1;
        return windowLength-maxFreq <= k;
    }
}