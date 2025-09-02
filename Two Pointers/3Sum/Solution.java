class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String> threeSumTriplets=new HashSet<>();

        for(int i=0;i<nums.length-2;i++) {
            List<int[]> twoSumIndPairs=getTwoSum(nums, i+1, -nums[i]);
            for(int[] twoSumInds : twoSumIndPairs) {
                if(twoSumInds[0]<twoSumInds[1]) {
                    threeSumTriplets.add(nums[i]+","+nums[twoSumInds[0]]+","+nums[twoSumInds[1]]);
                } else if(twoSumInds[0]>twoSumInds[1]) {
                    threeSumTriplets.add(nums[i]+","+nums[twoSumInds[1]]+","+nums[twoSumInds[0]]);
                }
            }
        }

        return getSolution(threeSumTriplets);
    }

    private List<List<Integer>> getSolution(Set<String> threeSumTriplets) {
        List<List<Integer>> solution = new ArrayList<>();

        for(String threeSumTriplet:threeSumTriplets) {
            List<Integer> triplet=new ArrayList<>();
            String[] arr=threeSumTriplet.split(",");

            triplet.add(Integer.valueOf(arr[0]));
            triplet.add(Integer.valueOf(arr[1]));
            triplet.add(Integer.valueOf(arr[2]));

            solution.add(triplet);
        }

        return solution;
    }

    private List<int[]> getTwoSum(int[] nums, int startInd, int target) {
        List<int[]> twoSumIndPairs=new ArrayList<>();
        int j=startInd, k=nums.length-1;

        while(j<k) {
            if(nums[j]+nums[k]<target) {
                j++;
            } else if(nums[j]+nums[k]>target) {
                k--;
            } else {
                twoSumIndPairs.add(new int[] { j,k });
                j++; k--;
            }
        }

        return twoSumIndPairs;
    }
}