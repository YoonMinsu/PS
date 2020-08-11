import java.io.*;

public class Main {
    private static final int MOD = 10_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int x = Integer.parseInt( br.readLine() );

        int[] dp = new int[ x + 1 ];

        dp[ 0 ] = 1;
        dp[ 1 ] = 1;

        for ( int i = 2; i <= x; ++i ) {
            dp[ i ] = ( dp[ i - 2 ] + dp[ i - 1 ] ) % MOD;
        }
        System.out.println( dp[ x ] % MOD );
    }
}
