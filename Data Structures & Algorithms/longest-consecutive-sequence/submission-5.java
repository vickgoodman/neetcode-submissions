class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (int entry : set) {
            if (set.contains(entry - 1)) {
                continue;
            }

            int len = 1;
            while (set.contains(entry + len)) {
                len++;
            }

            if (len > longest) {
                longest = len;
            }
        }
        
        return longest;
    }
}
