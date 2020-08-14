import java.io.*;

public class Main {
    public static int lengthOfLIS( int[] nums, int num ) {
        int[] dp = new int[ num ];
        dp[ 0 ] = 1;
        for ( int i = 1; i < num; ++i ) {
            int len = 0;
            for ( int j = 0; j < i; ++j ) {
                if( nums[ i ] > nums[ j ] && dp[ j ] > len ) {
                    len = dp[ j ];
                }
            }
            dp[ i ] = len + 1;
        }

        int maxLength = 0;
        for ( int i = 0; i < num; ++i ) {
            maxLength = Math.max( maxLength, dp[ i ] );
        }
        return maxLength;
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

        System.out.println( result );

    }
}
