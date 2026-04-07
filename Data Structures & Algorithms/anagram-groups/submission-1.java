public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // hashmap with String as the key and a list of Strings as value
        Map<String, List<String>> map = new HashMap<>();

        // iterate through the Strings
        for (String str : strs) {
            int[] freq = new int[26];

            // update freq vector
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            // get the key
            String key = Arrays.toString(freq);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
