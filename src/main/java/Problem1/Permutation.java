package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        // homework
        //number of possible outcomes = n! (where n = number of elements)

        ArrayList<List<Integer>> perms = new ArrayList<List<Integer>>();    //list of permutations

        if(nums == null || nums.length == 0){       //if nums is empty, return empty list
            perms.add(toList(nums));                //add empty array into permutations list
            return perms;                           //return empty arrayList
        }

        boolean[] isUsed = new boolean[nums.length];                //which positions have been used
        ArrayList<Integer> permuted = new ArrayList<Integer>();     //holds the permuted list

        findPermutations(nums, permuted, isUsed, perms);            //finds all possible permutations
                                                                    //(pass by reference)
        return perms;   //return completed list
    }

    private static void findPermutations(
            int[] nums,                 //integer array
            List<Integer> permuted,     //permuted list of nums
            boolean[] isUsed,           //which positions have been used
            List<List<Integer>> perms)  //all possible permutations
    {
        if(permuted.size() == nums.length){                 //if the list is filled
            perms.add(new ArrayList<Integer>(permuted));    //add to list of possible permutations
            return;                                         //exit
        }

        for(int i = 0; i < nums.length; i++){
            if(isUsed[i]){  //if the number is being used, skip this iteration
                continue;
            }

            isUsed[i] = true;                                   //mark this current index as being used

            permuted.add(nums[i]);                              //add current index into current permutation solution
            findPermutations(nums, permuted, isUsed, perms);    //find permutations in all positions

            permuted.remove(permuted.size() - 1);             //remove first element (move down)
            isUsed[i] = false;                                  //reset used position to false
        }
    }

    //changes array to arraylist
    private static ArrayList<Integer> toList(int[] array){
        ArrayList<Integer> newList = new ArrayList<Integer>();

        for(int element : array){
            newList.add(element);
        }

        return newList;
    }
}
