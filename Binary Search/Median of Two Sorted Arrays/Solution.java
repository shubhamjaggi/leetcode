class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length, n=nums2.length;
        if(m>n) return findMedianSortedArrays(nums2, nums1);
        boolean isEven=(m+n)%2==0;
        int lo=0, hi=m;
        while(lo<=hi) {
            int cut1=(lo+hi)/2, cut2=((m+n)/2)-cut1;
            int l1=cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
            int l2=cut2==0?Integer.MIN_VALUE:nums2[cut2-1];
            int r1=cut1==m?Integer.MAX_VALUE:nums1[cut1];
            int r2=cut2==n?Integer.MAX_VALUE:nums2[cut2];
            if(l1>r2) hi=cut1-1;
            else if(l2>r1) lo=cut1+1;
            else return isEven ? (Math.max(l1,l2)+Math.min(r1,r2))/2.0 : Math.min(r1,r2);
        }
        return -1;
    }
}