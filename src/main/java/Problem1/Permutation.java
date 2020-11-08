package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        // homework
        //number of possible outcomes = n! (where n = number of elements)
        if(nums == null){
            return new ArrayList<List<Integer>>();
        }

        ArrayList<Integer> numsList = new ArrayList<Integer>();
        ArrayList<List<Integer>> permutations = new ArrayList<List<Integer>>();

        for(int num : nums){
            numsList.add(num);
        }

        for(int i = 0; i < nums.length; i++) {
            ArrayList<Integer> onePermutation = findPermutations(i, numsList);
            permutations.add(onePermutation);
        }
        return permutations; // place holder
    }

    private static ArrayList<Integer> findPermutations(int pos, ArrayList<Integer> inList){
        ArrayList<Integer> onePerm = new ArrayList<Integer>();

        //if(inList.)


        return onePerm;
    }
}
