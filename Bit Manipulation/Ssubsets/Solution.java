class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        for(int i=0; i < (1 << nums.length); i++){
            List<Integer> set = new ArrayList<>();
            for(int j=0; j < nums.length; j++){
                if((i & (1 << j)) != 0) set.add(nums[j]);
            }
            powerset.add(set);
        }
        return powerset;
    }
}