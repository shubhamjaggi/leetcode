class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) return 1;

        int count = 1;
        int i = 1;

        while(i < nums.length && nums[i] == nums[i - 1]) i++;

        if(i < nums.length) {
            int prevDiff = nums[i] - nums[i - 1];

            count++;
            i++;

            for(; i < nums.length; i++) {
                int currDiff = nums[i] - nums[i - 1];
                if(currDiff != 0){
                    if((prevDiff < 0 && currDiff > 0) || (prevDiff > 0 && currDiff < 0)) count++;
                    prevDiff = currDiff;
                }
            }

            return count;
        }else{
            return 1;
        }
    }
}