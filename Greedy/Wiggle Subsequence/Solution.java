class Solution {
    public int wiggleMaxLength(int[] nums) {
            Integer prevDiff = null;
            int count = 1;
            for(int i = 1; i < nums.length; i++) {
                int currDiff = nums[i] - nums[i - 1];
                if(currDiff != 0){
                    if((prevDiff == null) || (prevDiff < 0 && currDiff > 0) || (prevDiff > 0 && currDiff < 0)) count++;
                    prevDiff = currDiff;
                }
            }
            return count;
    }
}