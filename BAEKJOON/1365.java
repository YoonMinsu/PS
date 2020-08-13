import java.io.*;

public class Main {
    public static int lowerBound( int[] dp, int idx, int target ) {
        int start = 0, end = idx, mid = 0;
        while ( start < end ) {
            mid = ( start + end ) / 2;

            if( dp[ mid ] < target ) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
    public static int lengthOfLIS( int[] nums, int num ) {

        int[] dp = new int[ num ];

        dp[ 0 ] = nums[ 0 ];
        int idx = 0;
        for ( int i = 1; i < num; ++i ) {
            if( dp[ idx ] < nums[ i ] ) {
                dp[ ++idx ] = nums[ i ];
            } else {
                int newIdx = lowerBound( dp, idx, nums[ i ] );
                dp[ newIdx ] = nums[ i ];
            }
        }

        return idx + 1;
    }
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int num = Integer.parseInt( br.readLine() );

        int[] nums = new int[ num ];
        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < num; ++i ) {
            nums[ i ] = Integer.parseInt( line[ i ] );
        }

        int result = lengthOfLIS( nums, num );

        System.out.println( num - result );
    }
}
