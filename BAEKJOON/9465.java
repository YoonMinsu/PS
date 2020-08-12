import java.io.*;

class BaekJoon_9465 {
    private static int[][] dp;
    private static int[][] result;

    private void initArr(int n, BufferedReader br) throws IOException {
        dp = new int[ 3 ][ n + 1 ];
        result = new int[ 3 ][ n + 1 ];

        for (int i = 1; i <= 2; ++i) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = Integer.parseInt(line[j-1]);
            }
        } // end for
    }

    private int solve(int n, BufferedReader br) throws IOException {

        initArr(n,br);

        result[ 1 ][ 1 ] = dp[ 1 ][ 1 ];
        result[ 2 ][ 1 ] = dp[ 2 ][ 1 ];
        result[ 1 ][ 2 ] = dp[ 1 ][ 2 ] + dp[ 2 ][ 1 ];
        result[ 2 ][ 2 ] = dp[ 1 ][ 1 ] + dp[ 2 ][ 2 ];

        for ( int i = 3; i <= n; ++i ) {
            result[ 1 ][ i ] = dp[ 1 ][ i ] + Math.max( result[ 2 ][ i - 1 ], result[ 2 ][ i - 2 ] );
            result[ 2 ][ i ] = dp[ 2 ][ i ] + Math.max( result[ 1 ][ i - 1 ], result[ 1 ][ i - 2 ] );
        }
        return Math.max( result[ 1 ][ n ], result[ 2 ][ n ] );
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; ++i) {
            int num = Integer.parseInt(br.readLine());

            int result = solve(num, br);

            bw.write(result+"\n");
        } // end for
        bw.flush();
        bw.close();
        br.close();
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_9465().solution();
    }
}
