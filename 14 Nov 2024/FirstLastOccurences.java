import java.util.ArrayList;
import java.util.Scanner;

public class FirstLastOccurences {
    private static int first = Integer.MAX_VALUE;
    private static int last = Integer.MIN_VALUE;

    private static void binarySearch(int[] arr, int left, int right, int target) {
        if (left > right)
            return;
        int mid = (int) (left + right) / 2;
        if (arr[mid] == target) {
            if (first == Integer.MAX_VALUE && last == Integer.MIN_VALUE) {
                first = mid;
                last = mid;
            } else if (mid < first) {
                first = mid;
            } else if (mid > last) {
                last = mid;
            }
        }
        binarySearch(arr, left, mid - 1, target);
        binarySearch(arr, mid + 1, right, target);
    }

    private static ArrayList<Integer> find(int arr[], int x) {
        binarySearch(arr, 0, arr.length - 1, x);
        ArrayList<Integer> result = new ArrayList<>();
        if (first != Integer.MAX_VALUE) {
            result.add(first);
        } else {
            result.add(-1);
        }
        if (last != Integer.MIN_VALUE) {
            result.add(last);
        } else {
            result.add(-1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }
        int target = scan.nextInt();
        ArrayList<Integer> result = find(arr, target);
        System.out.printf("First: %d - Last: %d", result.get(0), result.get(1));
        scan.close();
    }
}
