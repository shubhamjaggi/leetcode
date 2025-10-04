class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs) {
            char[] strChars=str.toCharArray(); Arrays.sort(strChars);
            String key=String.valueOf(strChars);
            map.computeIfAbsent(key, k->new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}