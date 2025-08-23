class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { getFirstPos(nums, target), getLastPos(nums, target) };
    }

    private int getFirstPos(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int firstPos = -1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid]==target) {
                firstPos = mid;
                end = mid-1;
            } else if(nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return firstPos;
    }

    private int getLastPos(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int lastPos = -1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid]==target) {
                lastPos = mid;
                start = mid+1;
            } else if(nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return lastPos;
    }
}