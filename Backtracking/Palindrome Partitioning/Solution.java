class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions=new ArrayList<>();
        /* our solution would be a list of partitions; a partition is made up of substrings;
            a partition will have breakpoints that will divide the whole string into the required substrings;
            for example -> "a", "bb", "ccc" -> this is a partition with 2 breakpoints; 1st right after 'a' and 2nd right after the 2 b's;
        */
        addPartitions(s, 0, new ArrayList<>(), partitions);
        return partitions;
    }

    private void addPartitions(String s, int i, List<String> cp, List<List<String>> partitions) { // i is the index right after the last breakpoint till now // cp=>'current partition' built up till now
        int n=s.length();
        if(i==n) { partitions.add(new ArrayList<>(cp)); return; } // create new list because 'cp' would ultimately become empty
        for(int j=i;j<n;j++) {
            if(isPalindrome(s, i, j)) { // j is now the index that is right before the next breakpoint
                cp.add(s.substring(i, j+1)); // save the substring from i to j
                addPartitions(s, j+1, cp, partitions); // recursion // complete all partitions that have the substring i->j
                cp.remove(cp.size()-1); // backtrack
            }
        }
    }

    private boolean isPalindrome(String str, int left, int right) {
        while(left<right) {
            if(str.charAt(left++)!=str.charAt(right--)) return false;
        }
        return true;
    }
}