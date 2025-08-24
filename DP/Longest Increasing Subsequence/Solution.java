class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int outer=1; outer<nums.length; outer++) {
            for(int inner=0; inner<outer; inner++) {
                if(nums[outer]>nums[inner]) {
                    // calculate the length of LIS that ends at index 'outer' (selecting num at this index)
                    dp[outer] = Math.max(dp[outer], 1+dp[inner]);
                }
            }
        }

        return max(dp);
    }

    private int max(int[] nums) {
        int ans=Integer.MIN_VALUE;
        for(int num:nums) ans=Math.max(ans, num);
        return ans;
    }