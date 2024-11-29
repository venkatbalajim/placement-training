import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NonRepeatingElement {
    public static char nonRepeatingChar(String s) {
        List<Character> letters = new ArrayList<>();
        Map<Character, Integer> freq = new HashMap<>();
        for (char letter : s.toCharArray()) {
            if (!freq.containsKey(letter)) {
                letters.add(letter);
                freq.put(letter, 1);
            } else {
                freq.put(letter, freq.get(letter) + 1);
            }
        }
        for (char letter : letters) {
            if (freq.get(letter) == 1) {
                return letter;
            }
        }
        return '$';
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        System.out.println(nonRepeatingChar(input));
        scan.close();
    }
}
