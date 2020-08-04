import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );

        int[] arr = new int[ n ];
        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i ] );
        }

        Arrays.sort( arr );

        int target = Integer.parseInt( br.readLine() );
        int cnt = 0;
        int p1 = 0, p2 = n - 1;

        while ( p1 < p2 ) {

            int sum = arr[ p1 ] + arr[ p2 ];
            if ( sum == target ) {
                cnt++;
                p1++; p2--;
            } else if ( sum > target ) {
                p2--;
            } else {
                p1++;
            }

        } // end while

        System.out.println( cnt );
    }
}
