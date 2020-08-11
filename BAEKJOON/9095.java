import java.io.*;

class BaekJoon_9095 {
    private static int[] dp = new int[12];

    private void solve() {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11; ++i) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        solve();

        for (int t = 0; t < testCase; ++t) {
            int num = Integer.parseInt(br.readLine());
            bw.write(dp[num] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_9095().solution();
    }
}
