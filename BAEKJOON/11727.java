import java.io.*;

class BaekJoon_11727 {
    private static final int MOD = 10_007;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1_001];

        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[ i - 2 ] * 2) + dp[ i - 1 ]) % MOD;
        } // end for

        System.out.println(dp[n] % MOD);
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_11727().solution();
    }
}
