class Solution {
    public boolean canJump(int[] nums) {
        int maxInd = 0;
        int i = 0;
        for (; i < nums.length && i<=maxInd; i++) {
            maxInd = Math.max(maxInd, i + nums[i]);
        }
        return i==nums.length;
    }
}