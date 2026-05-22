class Solution {
    static void bkt(int step, int stop, int[] domain,
                    List<Integer> currSolution,
                    List<List<Integer>> allSolutions,
                    Set<Integer> visited) {
        if (step == stop) {
            allSolutions.add(new ArrayList<>(currSolution));
        }

        for (int elem : domain) {
            if (!visited.contains(elem)) {
                visited.add(elem);
                currSolution.add(elem);

                bkt(step + 1, stop, domain, currSolution, allSolutions, visited);

                visited.remove(elem);
                currSolution.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> allSolutions = new ArrayList<>();
        List<Integer> currSolution = new ArrayList<>();

        bkt(0, nums.length, nums, currSolution, allSolutions, visited);

        return allSolutions;
    }
}
