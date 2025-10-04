class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length; int[] res=new int[n];

        res[0]=1; // initially res[i] will store only prefix product
        for(int i=1;i<n;i++) {
            res[i]=res[i-1]*nums[i-1];
        }

        int sufProduct=1; // variable to hold suffix product
        for(int i=n-2;i>=0;i--) {
            sufProduct*=nums[i+1];
            res[i]*=sufProduct; // multiply stored prefix product with suffix product
        }

        return res;
    }
}