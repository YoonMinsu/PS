import java.io.*;

class BaekJoon_2631 {

    private int lowerBound( int[] dp, int end, int key ) {
        int start = 0, mid = 0;

        while (start < end) {

            mid = ( start + end ) / 2;

            if ( dp[ mid ] < key ) {
                start = mid + 1;
            } else {
                end = mid;
            }

        } // end while

        return end;
    }

    private int getMinCount( int[] nums, int num ) {
        int[] dp = new int[ num ];

        dp[ 0 ] = nums[ 0 ];
        int idx = 0;
        for ( int i = 1; i < num; ++i ) {
            if ( dp[ idx ] < nums[ i ] ) {
                dp[ ++idx ] = nums[ i ];
            } else {
                int newIdx = lowerBound( dp, idx, nums[ i ] );
                dp[ newIdx ] = nums[ i ];
            }
        } // end for

        return idx + 1;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int num = Integer.parseInt( br.readLine() );

        int[] nums = new int[ num ];
        for ( int i = 0; i < num; ++i ) {
            nums[ i ] = Integer.parseInt( br.readLine() );
        }

        int result = num - getMinCount( nums, num );
        System.out.println( result );

    }

    public void run() throws IOException {
        solution();
    }
}

public class Main {
    public static void main( String[] args ) throws IOException {
        new BaekJoon_2631().run();
    }
}
