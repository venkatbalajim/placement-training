import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    private static int memoization(int[] coins, int sum, int n, int[][] dp) {
        if (sum == 0) {
            return dp[n][sum] = 1;
        } else if (n == 0 || sum < 0) {
            return 0;
        } else if (dp[n][sum] != -1) {
            return dp[n][sum];
        } else {
            return dp[n][sum] = memoization(coins, sum - coins[n - 1], n, dp) + memoization(coins, sum, n - 1, dp);
        }
    }

    public static int count(int[] coins, int sum) {
        int[][] dp = new int[coins.length + 1][sum + 1];
        for (int i = 0; i <= coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return memoization(coins, sum, coins.length, dp);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = scan.nextInt();
        int[] coins = new int[length];
        for (int i = 0; i < length; i++) {
            coins[i] = scan.nextInt();
        }
        int sum = scan.nextInt();

        int result = count(coins, sum);
        System.out.printf("Result: %d", result);

        scan.close();
    }
}
