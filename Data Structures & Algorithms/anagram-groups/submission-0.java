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

            // check if the map contains the same freq vector
            if (map.containsKey(key)) {
                // get the list of strings and add the new value
                List<String> value = map.get(key);
                value.add(str);
            } else {
                // if it doesn't contain the freq vector, add it
                ArrayList<String> value = new ArrayList<>();
                value.add(str);
                map.put(key, value);
            }
        }

        List<List<String>> group = new ArrayList<>();
        for (String keyEntry : map.keySet()) {
            List<String> list = map.get(keyEntry);

            group.add(list);
        }

        return group;
    }
}
