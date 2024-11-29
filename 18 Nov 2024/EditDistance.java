import java.util.Scanner;

public class EditDistance {
    public static int memoization(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (memo[m][n] != -1)
            return memo[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memo[m][n] = memoization(s1, s2, m - 1, n - 1, memo);
        } else {
            int insert = memoization(s1, s2, m, n - 1, memo);
            int remove = memoization(s1, s2, m - 1, n, memo);
            int replace = memoization(s1, s2, m - 1, n - 1, memo);
            memo[m][n] = 1 + Math.min(insert, Math.min(remove, replace));
        }

        return memo[m][n];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        System.out.println(memoization(s1, s2, m, n, memo));
        scan.close();
    }
}
