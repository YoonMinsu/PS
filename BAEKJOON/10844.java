import java.io.*;

class BaekJoon_10844 {
    private static final int MOD = 1_000_000_000;
    private static long[][] dp = new long[101][11];

    // dp[N][L] = dp[N - 1][L - 1] + dp[N - 1][L + 1]
    // 길이 N, 마지막 숫자가 L일 경우
    private void solve(int num, BufferedWriter bw) throws IOException {

        for (int i = 1; i <= 9; ++i) {
            dp[1][i] = 1;
        }

        for ( int i = 2; i <= num; ++i ) {
            dp[ i ][ 0 ] = dp[ i - 1 ][ 1 ];
            for ( int j = 1; j <= 9; ++j ) {
                dp[ i ][ j ] = ( dp[ i - 1 ][ j - 1 ] + dp[ i - 1 ][ j + 1 ] ) % MOD;
            }
        } // end for

        long sum = 0;
        for ( int i = 0; i < 10; ++i ) {
            sum = sum + dp[ num ][ i ];
        }
        bw.write( String.valueOf( sum % MOD ) );
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
        new BaekJoon_10844().solution();
    }
}
