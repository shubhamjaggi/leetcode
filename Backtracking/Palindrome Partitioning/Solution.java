class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions=new ArrayList<>();
        addPartitions(s, 0, new ArrayList<>(), partitions);
        return partitions;
    }

    private void addPartitions(String s, int i, List<String> cp, List<List<String>> partitions) { // i is starting index of current partition // cp=>current partition
        int n=s.length();
        if(i==n) { partitions.add(new ArrayList<>(cp)); return; } // create new list because 'cp' would ultimately become empty
        for(int j=i;j<n;j++) {
            if(isPalindrome(s, i, j)) { // j being the index just before the next substring of the current partition
                cp.add(s.substring(i, j+1));
                addPartitions(s, j+1, cp, partitions); // recursion // create remaining substrings of the current partition
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