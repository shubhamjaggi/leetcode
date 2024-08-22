class Solution {
    public void nextPermutation(int[] nums) {
        int i1 = -1;
        for(int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                i1 = i;
                break;
            }
        }

        if (i1 == -1) {
            reverse(nums, 0);
            return;
        }

        int i2 = -1;

        for(int i = nums.length-1; i >= i1+1; i--) {
            if (nums[i1] < nums[i]) {
                i2 = i;
                break;
            }
        }

        swap(nums, i1, i2);
        reverse(nums, i1+1);
    }

    private void reverse(int[] nums, int start) {
        int length = nums.length - start + 1;
        int mid = start + (length/2);

        for(int i = start; i < mid ; i++) {
            swap(nums, i, nums.length - 1 - (i-start));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}