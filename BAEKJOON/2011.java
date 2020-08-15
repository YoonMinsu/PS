

class BaekJoon_2011 {
    private static final int MOD = 1_000_000;

    private void solution() throws java.io.IOException {
        java.io.BufferedReader br = new java.io.BufferedReader( new java.io.InputStreamReader( java.lang.System.in ) );

        String line = br.readLine();

        int length = line.length();

        int[] dp  = new int[ length + 1 ];
        int[] arr = new int[ length + 1 ];

        for ( int i = 0; i < length; ++i ) {
            arr[ i + 1 ] = line.charAt( i ) - '0';
        }

        dp[ 0 ] = 1;

        for ( int i = 1; i <= length; ++i ) {

            if ( arr[ i ] != 0 ) {
                dp[ i ] = ( dp[ i - 1 ] + dp[ i ] ) % MOD;
            }

            int x = arr[ i ] + arr[ i - 1 ] * 10;

            if ( 10 <= x && x <= 26 ) {
                dp[ i ] = ( dp[ i - 2 ] + dp[ i ] ) % MOD;
            }

        } // end for

        System.out.println( dp[ length ] % MOD );

    }

    public void run() throws java.io.IOException {
        solution();
    }
}

public class Main {
    public static void main( String[] args ) throws java.io.IOException {
         new BaekJoon_2011().run();
    }
}
