class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charKey = str.toCharArray();
            Arrays.sort(charKey);
            String key = new String(charKey);

            List<String> val;
            if (anagramMap.containsKey(key)) {
                val = anagramMap.get(key);
            } else {
                val = new ArrayList<>();
            }

            val.add(str);
            anagramMap.put(key, val);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }
}
