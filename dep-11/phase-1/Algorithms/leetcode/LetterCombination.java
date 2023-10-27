import java.util.*;


public class LetterCombination {
    public static void main(String[] args) {
        String digits = "232";
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(digits));
    }
}

class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        String[][] letterKeys = {{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        if(digits.length() == 0) combinations.add("");
        else if(digits.length() == 1) for (String str : letterKeys[Integer.valueOf(digits)-2]) combinations.add(str);
        else {
            for (int i = 0; i < digits.length(); i++) {
                
            }
        }
        return combinations;
    }

    public  makeCombinations(){

    }
}
