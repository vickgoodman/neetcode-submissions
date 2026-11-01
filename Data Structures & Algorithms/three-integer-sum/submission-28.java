class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int a = nums[i];
            if (a > 0) { break; }
            if (i > 0 && nums[i - 1] == nums[i]) {
                i++;
                continue;    
            }
            
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int currSum = nums[i] + nums[l] + nums[r];

                if (currSum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else if (currSum < 0) {
                    l++;
                } else {
                    r--;
                }
            }

            i++;
        }

        return res;
    }
}
