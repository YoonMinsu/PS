import java.io.*;

public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );

        int[] dp  = new int[ n + 1 ];

        String[] line = br.readLine().split( " " );
        for( int i = 1; i <= n; ++i ) {
            dp[ i ] = Integer.parseInt( line[ i - 1 ] );
        }

        int max = dp[ 1 ];
        for ( int i = 2; i <= n; ++i ) {
            if( dp[ i - 1 ] > 0 && dp[ i ] + dp[ i -1 ] > 0 ) {
                dp[ i ] = dp[ i ] + dp[ i - 1 ];
            }
            
            if ( max < dp[ i ] ) {
                max = dp[ i ];
            }
        } // end for
        System.out.println( max );
    }
}
