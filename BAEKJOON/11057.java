import java.io.*;

class BaekJoon_11057 {
    private static final int MOD = 10_007;
    private static long[][] dp = new long[1_001][11];
    private static long[] result = new long[1_001];

    private void solve(int num, BufferedWriter bw) throws IOException {
        for (int i = 0; i <= 9; ++i) {
            dp[1][i] = 1;
        }

        for (int i = 0; i <= 9; ++i) {
            dp[2][i] = 10 - i;
        }

        result[1] = 10;
        result[2] = 55;

        long sum = 0L;
        for (int i = 3; i <= num; ++i) {
            dp[i][0] = result[i-1];
            sum = dp[i][0];
            for (int j = 1; j <= 9; ++j) {
                dp[i][j] = (dp[i][j-1] - dp[i-1][j-1] + MOD) % MOD;
                sum = (sum + dp[i][j]) % MOD;
            }
            result[i] = sum;
        }


        bw.write(String.valueOf(result[num]));
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        solve(num, bw);

        bw.flush();
        bw.close();
        br.close();
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_11057().solution();
    }
}
