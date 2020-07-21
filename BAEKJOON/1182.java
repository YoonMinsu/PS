import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int count = 0;

    public static void powerSet( int[] arr, int n, int index, int sum, int s ) {
        if ( index == n ) {
            if ( sum == s ) {
                count++;
            }
            return;
        }

        powerSet( arr, n ,index + 1, sum, s );
        powerSet( arr, n ,index + 1, sum + arr[ index ], s );

    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        String[] line = br.readLine().split( " " );

        int n = Integer.parseInt( line[ 0 ] );
        int s = Integer.parseInt( line[ 1 ] );

        int[] arr = new int[ n ];

        line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i ] );
        }

        powerSet( arr, n ,0, 0, s );

        if ( s == 0 ) {
           count--;
        }
        System.out.println( count );
    }
}
