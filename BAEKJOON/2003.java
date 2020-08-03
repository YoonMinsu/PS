import java.io.*;

public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        String[] line = br.readLine().split( " " );

        int n = Integer.parseInt( line[ 0 ] );
        int m = Integer.parseInt( line[ 1 ] );

        int[] arr = new int[ n ];

        line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i ] );
        }

        int p1 = 0, p2 = 0;
        int cnt = 0, sum = 0;

        while ( true ) {

           if ( sum >= m ) {
               sum = sum - arr[ p1++ ];
           } else if ( p2 == n ) {
               break;
           } else {
               sum = sum + arr[ p2++ ];
           }

           if ( sum == m ) {
               cnt++;
           }
        } // end while

        System.out.println( cnt );

    }
}
