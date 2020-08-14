import java.io.*;

public class Main {
    public static int[] dp = new int[ 301 ];
    public static int[] arr = new int[ 301 ];
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );

        for ( int i = 1; i <= n; ++i ) {
            arr[ i ] = Integer.parseInt( br.readLine() );
        }

        dp[ 0 ] = 0;
        dp[ 1 ] = arr[ 1 ];
        dp[ 2 ] = dp[ 1 ] + arr[ 2 ];
        for ( int i = 3; i <= n; ++i ) {
            dp[ i ] = Math.max( dp[ i - 2 ] + arr[ i ], dp[ i - 3 ] + arr[ i ] + arr[ i - 1 ] );
        }

        System.out.println( dp[ n ] );
    }
}
