import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw;

    private static void print( int[] out, int r ) throws IOException {
        for ( int i = 0; i < r; ++i ) {
            bw.write( out[ i ] + " " );
        }
        bw.write( '\n' );
    }

    public static void permutation( int[] arr, int[] out, boolean[] visited, int depth, int n, int r, int start ) throws IOException {
        if ( depth == r ) {
            print( out, r );
            return;
        }

        int before = 0;
        for ( int i = start; i < n; ++i ) {

            if( !visited[ i ] && before != arr[ i ] ) {
                before = arr[ i ];
                visited[ i ] = true;
                out[ depth ] = arr[ i ];
                permutation( arr, out, visited, depth + 1, n, r, i );
                visited[ i ] = false;
            }
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        String[] line = br.readLine().split( " " );

        int n = Integer.parseInt( line[ 0 ] );
        int r = Integer.parseInt( line[ 1 ] );

        int[] arr = new int[ n ];
        int[] out = new int[ n ];
        boolean[] visited = new boolean[ n ];

        line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i ] );
        }


        Arrays.sort( arr );

        permutation( arr, out, visited, 0, n, r, 0 );

        bw.flush();
        bw.close();
        br.close();

    }
}
