class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int max = 0;
        Set<Character> charSet = new HashSet<>();

        while(j < s.length()){

            if(charSet.contains(s.charAt(j))){
                while(s.charAt(i) != s.charAt(j)){
                    charSet.remove(s.charAt(i));
                    i++;
                }
                charSet.remove(s.charAt(i));
                i++;
            }
            else{
                charSet.add(s.charAt(j));
                j++;
                max = max > (j - i) ? max : (j - i);
            }

        }

        return max;
    }
}