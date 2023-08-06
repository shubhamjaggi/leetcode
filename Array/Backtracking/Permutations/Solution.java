class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        solve(nums, 0, permutations);
        return permutations;
    }

    private void solve(int[] nums, int i, List<List<Integer>> permutations){
        if(i >= nums.length){
            permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            solve(nums, i+1, permutations);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}