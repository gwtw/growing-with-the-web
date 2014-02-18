import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<String> combinations = getCombinations("abc");
        
        assert permutations.size() == 7;
        assert permutations.contains("a");
        assert permutations.contains("b");
        assert permutations.contains("c");
        assert permutations.contains("ab");
        assert permutations.contains("ac");
        assert permutations.contains("bc");
        assert permutations.contains("abc");

  	    System.out.println("Tests passed");
    }
    
    public static ArrayList<String> getCombinations(String text) {
        ArrayList<String> results = new ArrayList<String>();
        for (int i = 0; i < text.length(); i++) {
            // Record size as we will be adding to the list
            int resultsLength = results.size();
            for (int j = 0; j < resultsLength; j++) {
                results.add(text.charAt(i) + results.get(j));
            }
            results.add(Character.toString(text.charAt(i)));
        }
        return results;
    }
}
