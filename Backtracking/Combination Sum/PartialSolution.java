class PartialSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> inputVals = Arrays.stream(candidates).sorted().distinct().boxed().collect(Collectors.toList());
        List<List<Integer>> combinations = new ArrayList<>(); 
        func(inputVals, target, new ArrayList<>(), combinations);
        return combinations;
    }

    private void func(List<Integer> nums, int target, List<Integer> combination, List<List<Integer>> combinations){
        if(target == 0) {
            combinations.add(new ArrayList<>(combination));
        }

        for(int i = 0; i < nums.size() && target >= nums.get(i); i++) {
            combination.add(nums.get(i));
            func(nums, target - nums.get(i), combination, combinations);
            combination.remove(nums.get(i));
        }
    }
}