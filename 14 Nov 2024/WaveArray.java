import java.util.Scanner;

public class WaveArray {
    public static void convertToWave(int[] arr) {
        int i = 0, j = 1;
        while (j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i += 2;
            j += 2;
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }
        convertToWave(arr);
        scan.close();
    }
}
