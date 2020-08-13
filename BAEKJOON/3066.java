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
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        int testCase = Integer.parseInt( br.readLine() );
        for ( int i = 0; i < testCase; ++i ) {

            int size = Integer.parseInt( br.readLine() );

            int[] nums = new int[ size ];
            for ( int idx = 0; idx < size; ++idx ) {
                nums[ idx ] = Integer.parseInt( br.readLine() );
            }

            int result = lengthOfLIS( nums, size );
            bw.write( result + "\n" );
        } // end for
        bw.flush();
        bw.close();
        br.close();
    }
}
