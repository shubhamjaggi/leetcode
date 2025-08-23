class Solution {
    public int search(int[] nums, int target) {
        return orchestrateSearch(nums, target, 0, nums.length-1);
    }

    private int orchestrateSearch(int[] nums, int target, int start, int end) {
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(nums[start]<=nums[mid]) { // left half is sorted
            if(target<=nums[mid] && target>=nums[start]) { // target in sorted left half
                return binarySearch(nums, target, start, mid); // simple binary search
            } else { // target in unsorted right half
                return orchestrateSearch(nums, target, mid+1, end); // recursive call
            }
        } else { //right half is sorted
            if(target>=nums[mid] && target<=nums[end]) { // target in sorted right half
                return binarySearch(nums, target, mid, end); //simple binary search
            } else { // target in unsorted left half
                return orchestrateSearch(nums, target, start, mid-1); // recursive call
            }
        }
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        while(start<=end) {
            int mid = (start+end)/2;
            if(nums[mid]==target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }
}