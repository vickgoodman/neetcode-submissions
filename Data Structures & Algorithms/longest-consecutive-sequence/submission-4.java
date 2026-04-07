class Solution {
    public int longestConsecutive(int[] nums) {
        // transform array to set
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
            
            longest = Math.max(len, longest);
        }

        return longest;
    }
}
