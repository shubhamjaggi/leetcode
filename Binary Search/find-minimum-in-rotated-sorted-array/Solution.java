class Solution {
    public int findMin(int[] nums) {
        int origZero=0;
        int start=0; int end=nums.length-1;

        while(start<=end) {
            int mid=(start+end)/2;
            if(nums[start]<=nums[mid]) {
                origZero = nums[start]<nums[origZero] ? start:origZero;
                start=mid+1;
            } else {
                origZero = nums[mid+1]<nums[origZero] ? mid:origZero;
                end=mid;
            }
        }

        return nums[origZero];
    }
}