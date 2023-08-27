/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        return getPossibilitiesUsingDP(n, dp);
    }

    public List<TreeNode> getPossibilitiesUsingDP(int n, Map<Integer, List<TreeNode>> dp) {

        if(dp.containsKey(n)) return dp.get(n);
        
        List<TreeNode> allPossibleFBT = new ArrayList<>();

        if(n % 2 == 0) {
            dp.put(n, allPossibleFBT);
            return allPossibleFBT;
        }

        if(n == 1) {
            allPossibleFBT.add(new TreeNode(0));
            dp.put(n, allPossibleFBT);
            return allPossibleFBT;
        }

        for(int i = 1; i < n; i++) {
            List<TreeNode> leftPossibilities = allPossibleFBT(i);
            List<TreeNode> rightPossibilities = allPossibleFBT(n - 1 - i);

            for(TreeNode leftPossibility : leftPossibilities) {
                for(TreeNode rightPossibility : rightPossibilities) {
                    allPossibleFBT.add(new TreeNode(0, leftPossibility, rightPossibility));
                }
            }
        }

        dp.put(n, allPossibleFBT);
        return allPossibleFBT;
    }
}