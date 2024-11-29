import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicatesSorted {
    private static int removeDuplicate(List<Integer> arr) {
        int index = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) != arr.get(index)) {
                index++;
                arr.set(index, arr.get(i));
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arr.add(scan.nextInt());
        }
        System.out.printf("Result: %d", removeDuplicate(arr));
        scan.close();
    }
}
