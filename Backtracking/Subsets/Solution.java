class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        backtrack(0, nums, temp, powerset);

        return powerset;
    }

    private void backtrack(int i, int[] nums, List<Integer> temp, List<List<Integer>> powerset) {
        if(i==nums.length) {
            powerset.add(temp.stream().collect(Collectors.toList())); // it is important to create a copy of temp
            return;
        }

        temp.add(nums[i]); // take ith element
        backtrack(i+1, nums, temp, powerset);

        temp.remove(temp.size()-1); // don't take ith element
        backtrack(i+1, nums, temp, powerset);
    }
}