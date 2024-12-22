class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, max=0;
        Set<Character> charSet = new HashSet<>();
        while(j < s.length()) {
            if(charSet.contains(s.charAt(j))) {
                while(s.charAt(i) != s.charAt(j)) charSet.remove(s.charAt(i++));
                charSet.remove(s.charAt(i++));
            }
            else {
                charSet.add(s.charAt(j++));
                max = Math.max(max, charSet.size());
            }
        }

        return max;
    }
}