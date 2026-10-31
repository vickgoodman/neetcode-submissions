class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map with key: nums[i], value: frequency
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.putIfAbsent(num, 0);
            freqMap.put(num, freqMap.get(num) + 1);
        }

        // create the freq buckets
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // return the first k starting from the end of the freq lists
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
