import java.io.*;
import java.util.Arrays;
public class Main {

    public static boolean isContinued() {

        return false;
    }
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );
        int m = Integer.parseInt( br.readLine() );

        String[] line = br.readLine().split( " " );

        int[] arr = new int[ n ];
        for ( int i = 0; i < n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i ] );
        }

        Arrays.sort( arr );
        int  cnt = 0;
        int p1 = 0, p2 = n - 1;

        while ( p1 < p2 ) {
            if ( arr[ p1 ] + arr[ p2 ] == m ) {
                p1++;
                p2--;
                cnt++;
            } else if ( arr[ p1 ] + arr[ p2 ] < m ) {
                p1++;
            } else {
                p2--;
            }
        }

        System.out.println( cnt );
    }
}
