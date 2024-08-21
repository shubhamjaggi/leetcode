class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int curr = 0;

        int high=0;
        int low=0;

        while(high < nums.length-1) {
            int nextHigh = high + 1;

            for (int i = low; i <= high; i++) {
                nextHigh = Math.max(nextHigh, i + nums[i]);
            }

            low = high + 1;
            high = Math.min(nums.length-1, nextHigh);
            
            jumps++;
        }

        return jumps;
    }
}