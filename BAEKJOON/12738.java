import java.io.*;

public class Main {
    public static int[] nums = new int[ 1_000_001 ];
    public static int[] dp   = new int[ 1_000_001 ];

    public static int lower_Bound( int end, int target ) {
        int start = 0, mid = 0;

        while ( start < end ) {
            mid = ( start + end ) / 2;
            if ( dp[ mid ] < target ) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );

        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            nums[ i ] = Integer.parseInt( line[ i ] );
        }

        dp[ 0 ] = nums[ 0 ];
        int idx = 0;
        for ( int i = 1; i < n; ++i ) {
            if ( dp[ idx ] < nums[ i ] ) {
                dp[ ++idx ] = nums[ i ];
            } else {
                int newIdx = lower_Bound( idx, nums[ i ] );
                dp[ newIdx ] = nums[ i ];
            }
        } // end for
        System.out.println( idx + 1 );
    }
}
