import java.io.*;

class BaekJoon_1818 {
    private int lowerBound( int[] dp, int end, int key ) {
        int start = 0;
        while ( start < end ) {
            int mid = ( start + end ) / 2;
            if ( dp[ mid ] < key ) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int num = Integer.parseInt( br.readLine() );

        if ( num == 1 ) {
            System.out.println( 1 );
            return;
        }

        int[] nums = new int[ num ];
        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < num; ++i ) {
            nums[ i ] = Integer.parseInt( line[ i ] );
        }

        int[] dp = new int[ num ];

        dp[ 0 ]  = nums[ 0 ];
        int idx = 0;
        for ( int i = 1; i < num; ++i ) {
            if ( dp[ idx ] < nums[ i ] ) {
                dp[ ++idx ] = nums[ i ];
            } else {
                int newIdx = lowerBound( dp, idx, nums[ i ] );
                dp[ newIdx ] = nums[ i ];
            }
        } // end for

        System.out.println( num - idx - 1 );
    }

    public void run() throws IOException {
        solution();
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_1818().run();
    }
}
