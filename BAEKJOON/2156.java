import java.io.*;

class BaekJoon_2156 {
    private static int[] dp;
    private static int[] result;

    private void initArr(int n, BufferedReader br) throws IOException {
        dp = new int[ n + 1 ];
        result = new int[ n + 1 ];

        for ( int i = 1; i <= n; ++i ) {
            dp[ i ] = Integer.parseInt( br.readLine() );
        }
    }

    private int solve(int n, BufferedReader br) throws IOException {

        initArr(n,br);

        if ( n == 1 ) {
            return dp[ n ];
        }

        result[ 1 ] = dp[ 1 ];
        result[ 2 ] = result[ 1 ] + dp[ 2 ];

        for ( int i = 3; i <= n; ++i ) {
            result[ i ] = Math.max( result[ i - 3 ] + dp[ i ] + dp[ i - 1 ], result[ i - 2 ] + dp[ i ] );
            result[ i ] = Math.max( result[ i ], result[ i - 1 ] );
        }

        return result[ n ];
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int num = Integer.parseInt(br.readLine());
        int result = solve(num, br);
        bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_2156().solution();
    }
}
