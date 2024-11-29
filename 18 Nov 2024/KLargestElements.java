import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {
    static List<Integer> kLargest(int arr[], int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int elt : arr) {
            queue.add(elt);
        }
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty() && k > 0) {
            int elt = queue.poll();
            answer.add(elt);
            k -= 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        List<Integer> result = kLargest(arr, k);
        System.out.println(result);
        scan.close();
    }
}
