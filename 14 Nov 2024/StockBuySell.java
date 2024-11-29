import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StockBuySell {
    private static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> segments = new ArrayList<>();
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] - A[i] > 0) {
                segments.add(new ArrayList<>(Arrays.asList(i, i + 1)));
            }
        }
        return segments;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println("Segments to buy & sell stocks: ");
        ArrayList<ArrayList<Integer>> result = stockBuySell(arr, length);
        for (ArrayList<Integer> segment : result) {
            System.out.println(segment.get(0) + " " + segment.get(1));
        }
        scan.close();
    }
}
