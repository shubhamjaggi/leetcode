class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0, fast=0;

        while(fast<nums.length) {
            if(slow==0 || nums[slow-1]!=nums[fast]) { // next unique number found
                nums[slow++]=nums[fast];
            }
            fast++;
        }

        return slow;
    }
}