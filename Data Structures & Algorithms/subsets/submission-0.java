public class Solution {
    /*
    back(Domain, Solution):
        if check(Solution):
            print(Solution)
            return

        for value in Domain:
            // DO
            Solution = Solution.push(value)
            Domain = Domain.erase(value)

            // RECURSION
            back(Domain, Solution)

            // UNDO
            Solution = Solution.pop()
            Domain = Domain.insert(value)
     */
    private void bkt(int[] domain, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= domain.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // decision to include nums[i]
        subset.add(domain[i]);
        bkt(domain, i + 1, subset, res);

        // decision to NOT include nums[i]
        subset.removeLast();
        bkt(domain, i + 1, subset, res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        bkt(nums, 0, subset, res);

        return res;
    }
}
