class Solution {
    public int removeDuplicates(int[] nums) {
        int inIndex=0; // index where non-dupl vals will be added // 0th index will keep the exsiting value
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1]<nums[i]) { // different val found
                nums[++inIndex]=nums[i]; // inIndex is incremented when a new value is found
            }
        }
        return inIndex+1; // +1 because num of vals needs to returned => not last input index (which is 0 based)
    }
}