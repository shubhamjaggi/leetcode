class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Elem[] elems=new Elem[n];
        for(int i=0;i<n;i++) elems[i]=new Elem(nums[i],i);

        Arrays.sort(elems, (a,b)->Integer.compare(a.val,b.val));

        int left=0; int right=nums.length-1;
        while(left<right) {
            int currSum=elems[left].val+elems[right].val;
            if(currSum<target) left++;
            else if(currSum>target) right--;
            else return new int[] {elems[left].ind,elems[right].ind};
        }
        return new int[] {0,0}; // will never happen
    }

    class Elem {
        int val;
        int ind;

        Elem(int val,int ind) {
            this.val=val;
            this.ind=ind;
        }
    }
}