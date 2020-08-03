import java.io.*;

public class Main {
    public static final int MAX = 100_001;
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        String[] line = br.readLine().split( " " );

        int N = Integer.parseInt( line[ 0 ] );
        int S = Integer.parseInt( line[ 1 ] );

        int[] arr = new int[ N ];
        line = br.readLine().split( " " );
        for ( int i = 0; i < N; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i ] );
        }

        int answer = MAX, sum = 0;
        int p1 = 0, p2 = 0;

        while( true ) {
            if ( sum >= S ) {
                sum = sum - arr[ p1++ ];
                answer = Math.min( answer, ( p2 - p1 ) + 1 );
            } else if ( p2 == N ) {
                break;
            } else {
                sum = sum + arr[ p2++ ];
            }
        } // end while

        if ( answer == MAX ) {
            System.out.println( 0 );
        } else {
            System.out.println( answer );
        }

    }
}
