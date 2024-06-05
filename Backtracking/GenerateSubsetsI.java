package dsa.solutions.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class GenerateSubsetsI {
    public static void main(String[] args){
        ArrayList<Integer> input = (ArrayList)List.of(5,2,9);
        int curr_index = 0;
        ArrayList<Integer> temp_subset = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generate(input, curr_index, temp_subset,result);
        System.out.println("Result: "+result);
    }

    /**
     * Sorting subsets
     * @param A
     * @return
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> tmpSet = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // A-> given input elements
        //i-> current fixing element index
        //tmpSet -> current forming subset
        //ans -> all formed subsets
        Collections.sort(A);
        generate(A, 0, tmpSet, ans);
        //System.out.println("Ans = "+ans);
        ans.sort((set1, set2)->{
            return IntStream.range(0, Math.min(set1.size(), set2.size()))
                    .map(i-> Integer.compare(set1.get(i), set2.get(i)))
                    .filter(i -> i!=0)
                    .findFirst()
                    .orElse(Integer.compare(set1.size(), set2.size()));
        });
        //System.out.println("Ans = "+ans);
        return ans;
    }

    static void generate(ArrayList<Integer> input, int curr_index, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){
        if(curr_index == input.size()){
            res.add(new ArrayList<>(temp));
            return;
        }
        //we accept one number -> means we will add it into temp subset
        temp.add(input.get(curr_index));
        //every time we accept the element and proceed further until we reach all the elements
        // example input = [5,2,9] we accept until we reach [5,2,9] this is the leaf node
        generate(input, curr_index+1, temp, res);
        // As we are using arraylist to hold temp subset it holds all the previously added elements
        //if you want to reject the element, then we have to remove the last element from the list
        //eg: we reached [5,2,9] last selection was accept 9 after that we have to get reject 9 subset. for that, we need to remove the last element from temp subset
        //maintaining the state before decision is made
        temp.remove(temp.size()-1);

        //looking for the possibilities from the check point after rejecting the curr_index element
        generate(input, curr_index+1, temp, res);
    }
}
