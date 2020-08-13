import java.io.*;
import java.util.Stack;
class Pair {
    int idx;
    int value;

    public Pair( int idx, int value ) {
        this.idx = idx;
        this.value = value;
    }
}

public class Main {
    public static int[] nums  = new int[ 1_000_001 ];
    public static int[] dp    = new int[ 1_000_001 ];

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
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        int n = Integer.parseInt( br.readLine() );
        Pair[] tracking = new Pair[ n ];

        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            nums[ i ] = Integer.parseInt( line[ i ] );
        }

        dp[ 0 ] = nums[ 0 ];
        tracking[ 0 ] = new Pair( 0, nums[ 0 ] );
        int idx = 0;
        for ( int i = 1; i < n; ++i ) {
            if ( dp[ idx ] < nums[ i ] ) {
                dp[ ++idx ] = nums[ i ];
                tracking[ i ] = new Pair( idx, nums[ i ] );
            } else {
                int newIdx = lower_Bound( idx, nums[ i ] );
                dp[ newIdx ] = nums[ i ];
                tracking[ i ] = new Pair( newIdx, nums[ i ] );
            }
        } // end for
        bw.write( idx + 1 + "\n" );
        Stack<Integer> stack = new Stack<>();
        int temp = idx;
        for ( int i = n - 1; i >= 0; --i ) {
            if ( temp == tracking[ i ].idx ) {
                stack.push( tracking[ i ].value );
                temp--;
            }
        } // end for
        while ( !stack.isEmpty() ) {
            bw.write( stack.pop() + " " );
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
