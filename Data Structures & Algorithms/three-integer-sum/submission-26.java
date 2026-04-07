class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;
        int p1 = 0;

        while (p1 < n - 2) {

            // skip duplicate values for p1
            if (p1 > 0 && nums[p1] == nums[p1 - 1]) {
                p1++;
                continue;
            }

            int p2 = p1 + 1;
            int p3 = n - 1;

            int target = -nums[p1];
            while (p2 < p3) {
                int s = nums[p2] + nums[p3];

                if (s == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[p1]);
                    triplet.add(nums[p2]);
                    triplet.add(nums[p3]);
                    list.add(triplet);

                    // move both pointers
                    p2++;
                    p3--;

                    // skip duplicates for p2
                    while (p2 < p3 && nums[p2] == nums[p2 - 1]) {
                        p2++;
                    }

                    // skip duplicates for p3
                    while (p2 < p3 && nums[p3] == nums[p3 + 1]) {
                        p3--;
                    }

                } else if (s < target) {
                    p2++;
                } else {
                    p3--;
                }
            }

            p1++;
        }

        return list;
    }
}
