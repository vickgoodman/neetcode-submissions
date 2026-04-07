class Solution {
    public int longestConsecutive(int[] nums) {
        // transform array to set
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // what if I just stock the start of sequences
        List<Integer> seqStartList = new ArrayList<>();
        for (Integer entry : set) {
            if (set.contains(entry - 1)) {
                continue;
            }

            seqStartList.add(entry);
        }

        int maxSeqLength = 1;
        for (Integer entry : seqStartList) {
            int currSeqLength = 1;
            
            while (set.contains(entry + 1)) {
                currSeqLength++;    
                entry++;
            }

            if (currSeqLength > maxSeqLength) {
                maxSeqLength = currSeqLength;
            }
        }

        return maxSeqLength;
    }
}
