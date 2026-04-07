public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[][] freq = new int[2][2000];

        for (int num : nums) {
            freq[0][num + 1000] = num + 1000;
            freq[1][num + 1000]++;
        }

        for (int i = 0; i < 2000; i++) {
            for (int j = i + 1; j < 2000; j++) {
                if (freq[1][i] < freq[1][j]) {
                    int tmp = freq[1][j];
                    freq[1][j] = freq[1][i];
                    freq[1][i] = tmp;

                    tmp = freq[0][j];
                    freq[0][j] = freq[0][i];
                    freq[0][i] = tmp;
                }
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = freq[0][i] - 1000;
        }

        return ret;
    }
}
