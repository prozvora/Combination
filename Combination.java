import java.util.ArrayList;
import java.util.Arrays;
/*
 * Combination is a class which takes in a string and returns all possible combinations
 * of the characters in the string.
 * 
 * @author  Pavel Rozvora
 * @email   prozvora@gmail.com
 * @version 2015-10-02
 */
public class Combination {
    private static ArrayList<String> arr = new ArrayList<String>();
    /*
     * The main method initializes an array of the string's characters and sorts them
     * (order does not matter in a combination). It computes the combinations by calling
     * either the iterativeCombo or recursiveCombo methods and then prints the output.
     * 
     * @param   args[0]     Compute all combinations of this string's elements
     * @param   args[1]     Either "r" or "i", r for computing combinations recursively,
     *                      or i for computing combinations iteratively
     */
    public static void main (String[] args) {
        if (args.length != 2 || !(args[1].equals("r") || args[1].equals("i"))) usage();
        
        String string = args[0];
        char[] charArr = string.toCharArray();
        Arrays.sort(charArr);
        
        if (args[1].equals("r")) {
            String a = "";
            recursiveCombo(charArr, 0, true, a);
            recursiveCombo(charArr, 0, false, a);
        }
        
        if (args[1].equals("i")) {
            String sortedString = "";
            for (int i = 0; i < charArr.length; i++) {
                sortedString = sortedString + charArr[i];
            }
            iterativeCombo(sortedString);
        }
        printList();
    }
    /*
     * This method computes the combinations of s using the equivalent of a bitwise
     * and operator using a string representation of all base 2 numbers of the same
     * length as string s.
     * 
     * @param   s       Compute all combinations of this string's elements
     */
    public static void iterativeCombo(String s) {
        String[] binary = new String[(int) Math.pow(2,s.length())];
        for (int i = 0; i < binary.length; i++) {
            binary[i] = Integer.toBinaryString(i);
        }
        for (int j = 0; j < binary.length; j++) {
            String a = "";
            for (int k = 0; k < s.length(); k++) {
                if (binary[j].length()-k > 0 && 
                        binary[j].charAt(binary[j].length()-k-1) == '1') {
                    a = a + (s.charAt(s.length()-k-1));
                }
            }
            addString(a);
            
        }
    }
    /*
     * This method computes the combinations of s using recursion and by traversing
     * the string, either including or not including each individual index of the
     * passed in string.
     * 
     * @param   charArr     The array of all characters in the passed in string
     * @param   index       The current index in the array of characters
     * @param   include     If true, add the character at index to a, otherwise do not
     * @param   a           The resultant string, one combination of the elements of the
     *                      passed in string
     */
    public static void recursiveCombo(char[] charArr, int index, boolean include, String a) {
        if (index == charArr.length) {
            addString(a);
        } else {
            if (include) {
                a = a + charArr[index];
            }
            recursiveCombo(charArr, index+1, true, a);
            recursiveCombo(charArr, index+1, false, a);
        }
    }
    /*
     * Adds a character combination to the final list of all combinations unless
     * that combination already exists in the final list.
     * 
     * @param   combo   The string to be added to the list
     */
    public static void addString(String combo) {
        if (!arr.contains(combo)) {
            arr.add(combo);
        }
    }
    /*
     * Prints the final combination list to the standard output.
     * Formats the output.
     */
    public static void printList() {
        System.out.print("{ ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print("{");
            for (int j = 0; j < arr.get(i).length(); j++) {
                if (j != arr.get(i).length()-1) {
                    System.out.print(arr.get(i).substring(j, j+1));
                    System.out.print(", ");
                } else {
                    System.out.print(arr.get(i).substring(j));
                }
            }
            System.out.print("}");
            if (i < arr.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }
    /*
     * Prints a usage message to standard error if the program's parameters were
     * entered incorrectly.
     */
    private static void usage() {
        System.err.println("Usage: java ComboRecursive <STRING> <METHOD>");
        System.err.println("<STRING> is the string from which the combinations are generated.");
        System.err.println("<METHOD> chooses the function which performs the"
                + " combination operation.\nValid <METHOD> values are r and i, representing"
                + " recursive and iterative, respectively.");
        System.exit(0);
    }
}
