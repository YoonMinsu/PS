import java.io.*;

public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int num = Integer.parseInt( br.readLine() );

        if ( num == 1 ) {
            System.out.println( 0 );
            return;
        }

        int[] nums = new int[ num ];
        int[] dp = new int[ num ];

        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < num; ++i ) {
            nums[ i ] = Integer.parseInt( line[ i ] );
        }

        dp[ 0 ] = 1;
        for ( int i = 1; i < num; ++i ) {
            int len = 0;
            for ( int j = 0; j < i; ++j ) {
                if ( nums[ i ] < nums[ j ] && dp[ j ] > len ) {
                    len = dp[ j ];
                }
            }
            dp[ i ] = len + 1;
        } // end for

        int maxLength = 0;
        for ( int i = 0; i < num; ++i ) {
            maxLength = Math.max( maxLength, dp[ i ] );
        }
        System.out.println( num - maxLength );
    }
}
