public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Use hashmap with nums[i] as a key and frequency as a value
        Map<Integer, Integer> map = new HashMap<>();

        // compute all frequencies for all nums
        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Comparator<Map.Entry<Integer, Integer>> comp =
                new Comparator<>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                };

        list.sort(comp);

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = list.get(i).getKey();
        }

        return ret;
    }
}
