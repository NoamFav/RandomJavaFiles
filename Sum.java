import java.util.ArrayList;
import java.util.List;

public class Sum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;
        Sum finder = new Sum();
        List<List<Integer>> result = finder.findCombinations(array, target);
        System.out.println("all the way to make " + target + " whith the list is" + result);
    }

    public List<List<Integer>> findCombinations(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinationsHelper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void findCombinationsHelper(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        // Include current number
        current.add(candidates[index]);
        findCombinationsHelper(candidates, target - candidates[index], index + 1, current, result);
        current.remove(current.size() - 1); // remove the last element for backtracking

        // Skip current number
        findCombinationsHelper(candidates, target, index + 1, current, result);
    }
}
