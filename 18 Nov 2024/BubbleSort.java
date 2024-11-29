import java.util.Scanner;

public class BubbleSort {
    public static int[] bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int elt : arr) {
            System.out.print(elt + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }
        int[] result = bubbleSort(arr);
        printArray(result);
        scan.close();
    }
}
