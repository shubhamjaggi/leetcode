class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        String first = strs[0];
        boolean isLongerMatch=true;

        for(int i=0; i<first.length() && isLongerMatch; i++) {
            char ch = first.charAt(i);

            for(int j=1; j<strs.length; j++) {
                if (i == strs[j].length() || (i < strs[j].length() && strs[j].charAt(i)!=ch)) {
                    isLongerMatch=false;
                    break;
                }
            }
            
            if(isLongerMatch) ans.append(ch);
        }

        return ans.toString();
    }
}