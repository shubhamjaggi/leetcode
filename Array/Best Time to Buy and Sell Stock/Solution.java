class Solution {
    public int maxProfit(int[] prices) {
        int res = Integer.MIN_VALUE;
        int maxSoFar = Integer.MIN_VALUE;
        for(int i=prices.length-1; i>=0; i--){
            maxSoFar = Math.max(maxSoFar, prices[i]);
            res = Math.max(res, maxSoFar-prices[i]);
        }
        return res;
    }
}