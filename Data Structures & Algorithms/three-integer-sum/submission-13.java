class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;
        int p1 = 0;

        while (p1 < n - 2) {
            int p2 = p1 + 1;
            int p3 = n - 1;

            int target = -nums[p1];
            while (p2 < p3) {
                int s = nums[p2] + nums[p3];

                if (s == target) {
                    // add
                    List<Integer> triplet = new ArrayList<>();

                    triplet.add(nums[p1]);
                    triplet.add(nums[p2]);
                    triplet.add(nums[p3]);

                    if (!list.contains(triplet)) {
                        list.add(triplet);
                    }

                    p2++;
                    p3--;
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
