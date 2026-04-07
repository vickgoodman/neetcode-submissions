class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

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
