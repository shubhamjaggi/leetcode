class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> inputVals = Arrays.stream(candidates).sorted().distinct().boxed().collect(Collectors.toList());
        List<List<Integer>> combinations = new ArrayList<>(); 
        func(inputVals, target, new ArrayList<>(), combinations, 0);
        return combinations;
    }

    private void func(List<Integer> nums, int target, List<Integer> combination, List<List<Integer>> combinations, int i){
        if(target == 0) {
            combinations.add(new ArrayList<>(combination));
        }

        for(; i < nums.size() && target >= nums.get(i); i++) {
            combination.add(nums.get(i));
            func(nums, target - nums.get(i), combination, combinations, i);
            combination.remove(nums.get(i));
        }
    }
}