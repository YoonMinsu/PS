import java.io.*;

public class Main {
    public static int lengthOfBox( int[] nums ) {
        int length = nums.length;

        int dp[] = new int[ length ];

        dp[ 0 ] = 1;
        for ( int i = 1; i < length; ++i ) {
            int len = 0;
            for ( int j = 0; j < i; ++j ) {
                if ( nums[ i ] > nums[ j ] && dp[ j ] > len  ) {
                    len = dp[ j ];
                }
            }
            dp[ i ] = len + 1;
        }

        int maxLength = 0;
        for ( int i = 0; i < length; ++i ) {
            maxLength = Math.max( maxLength, dp[ i ] );
        }
        return maxLength;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );
        int[] arr = new int[ n ];

        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i ] );
        }

        int answer = lengthOfBox( arr );

        System.out.println( answer );
    }
}
