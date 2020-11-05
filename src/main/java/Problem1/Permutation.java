package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        // homework
        //number of possible outcomes = n! (where n = number of elements)
        List<List<Integer>> results = new ArrayList<>();
        findPermutations(nums, 0, results);
        return results; // place holder
    }

    private static void findPermutations(int[] nums, int pos, List<List<Integer>> results){
        if(pos == nums.length - 1){
            List<Integer> permutation = new ArrayList<Integer>();

            for(int i = 0; i < nums.length; i++) {
                permutation.add(nums[i]);
            }

            return;
        }
    }
}
