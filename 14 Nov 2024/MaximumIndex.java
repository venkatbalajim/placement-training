import java.util.Scanner;
import java.util.Stack;

public class MaximumIndex {
    private static int maxIndexDiff(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty() || arr[stack.peek()] > arr[i]) {
                stack.push(i);
            }
        }
        int diff = 0;
        int index = arr.length - 1;
        while (index > -1) {
            if (!stack.isEmpty() && arr[stack.peek()] <= arr[index]) {
                diff = Math.max(diff, index - stack.pop());
                continue;
            }
            index--;
        }
        return diff;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }
        int result = maxIndexDiff(arr);
        System.out.printf("Result: %d", result);
        scan.close();
    }
}
