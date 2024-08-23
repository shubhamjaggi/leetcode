class Solution {
    public int[] sortArray(int[] nums) {
        return sort(nums, 0, nums.length-1);
    }

    private int[] sort(int[] nums, int start, int end) {
        if (start == end) {
            int[] sorted = { nums[start] };
            return sorted;
        }
        int mid = (start + end)/2;
        int[] arr1 = sort(nums, start, mid);
        int[] arr2 = sort(nums, mid+1, end);
        return merge(arr1, arr2);
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int i=0, j=0, z=0;
        int[] merged = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                merged[z++] = arr1[i++];
            }
            else if (arr2[j] < arr1[i]) {
                merged[z++] = arr2[j++];
            }
            else {
                merged[z++] = arr1[i++];
                merged[z++] = arr2[j++];
            }
        }

        while(i < arr1.length) {
            merged[z++] = arr1[i++];
        }

        while(j < arr2.length) {
            merged[z++] = arr2[j++];
        }

        return merged;
    }
}