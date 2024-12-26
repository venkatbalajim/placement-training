import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubsequence {
    public static int lengthOfLongestSubstring(String s) {
        char[] letters = s.toCharArray();
        int i = 0, j = 0;
        int curr = 0;
        int answer = 0;

        Map<Character, Integer> pos = new HashMap<>();
        while (i < letters.length && j < letters.length) {
            char letter = letters[j];
            if (!pos.containsKey(letter)) {
                curr += 1;
                pos.put(letter, j);
                if (j < letters.length - 1) {
                    j += 1;
                } else {
                    i += 1;
                }
            } else {
                answer = Math.max(answer, curr);
                i = pos.get(letter) + 1;
                pos.remove(letter);
                curr = j - i;
            }
        }

        answer = Math.max(answer, curr);
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        System.out.println(lengthOfLongestSubstring(input));
        scan.close();
    }
}
