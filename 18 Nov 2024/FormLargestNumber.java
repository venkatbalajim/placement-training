import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FormLargestNumber {
    public static String printLargest(String[] arr) {
        String result = new String();
        List<String> list = new ArrayList<>();
        for (String elt : arr) {
            list.add(elt);
        }

        // The most crucial point to remember ...
        Collections.sort(list, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        for (String elt : list) {
            result += elt;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        String[] arr = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.toString(scan.nextInt());
        }
        System.out.printf("Result: %s", printLargest(arr));
        scan.close();
    }
}
