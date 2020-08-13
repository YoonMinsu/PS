import java.io.*;

public class Main {

    public static int[] lengthOfLIS( int[] nums ) {
        int size = nums.length;
        int[] dp = new int[ size ];

        dp[ 0 ] = 1;
        for ( int i = 1; i < size; ++i ) {
            int len = 0;
            for ( int j = 0; j < i; ++j ) {
                if( nums[ i ] > nums[ j ] && dp[ j ] > len ) {
                    len = dp[ j ];
                }
            }
            dp[ i ] = len + 1;
        }
        int maxLength = 0;
        for ( int i = 0; i < size; ++i ) {
            maxLength = Math.max( maxLength, dp[ i ] );
        }
        return dp;
    }
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );

        int[] arr1 = new int[ n ];
        int[] arr2 = new int[ n ];
        String[] line = br.readLine().split( " " );

        for ( int i = 0; i < n; ++i ) {
            arr1[ i ] = Integer.parseInt( line[ i ] );
        }

        int value = n - 1;
        for ( int i = 0; i < n; ++i ) {
            arr2[ i ] = arr1[ value - i ];
        }

        arr1 = lengthOfLIS( arr1 );
        arr2 = lengthOfLIS( arr2 );

        int[] result = new int[ n ];
        int answer = 0;
        for ( int i = 0; i < n; ++i ) {
            result[ i ] = arr1[ i ] + arr2[ value - i ];
        } // end for

        for ( int i = 0; i < n; ++i ) {
            answer = Math.max( answer, result[ i ] );
        }

        System.out.println( answer - 1 );
    }
}
