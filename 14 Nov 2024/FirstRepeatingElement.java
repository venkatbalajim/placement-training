import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FirstRepeatingElement {
    public static int firstRepeated(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> positions = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!freq.containsKey(arr[i])) {
                freq.put(arr[i], 1);
                positions.put(arr[i], i + 1);
            } else {
                set.add(positions.get(arr[i]));
            }
        }
        return set.isEmpty() ? -1 : set.iterator().next();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }
        int result = firstRepeated(arr);
        System.out.printf("Result: %d\n", result);
        scan.close();
    }
}
