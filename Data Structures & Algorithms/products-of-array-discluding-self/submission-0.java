public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prod = new int[n];

        for (int i = 0; i < n; i++) {
            prod[i] = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                prod[i] *= nums[j];
            }
        }

        return prod;
    }
}  
