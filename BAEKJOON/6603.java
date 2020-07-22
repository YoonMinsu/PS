import java.io.*;

public class Main {

    public static int[] arr;
    public static int[] out;
    public static boolean[] visited;
    public static BufferedWriter bw;

    public static void init( int n, String[] line ) {
        arr = new int[ n ];
        out = new int[ n ];
        visited = new boolean[ n ];

        for ( int i = 0; i < n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i + 1 ] );
        }
    }

    public static void permutation( int depth, int n, int r, int start ) throws IOException {
        if ( depth == r ) {
            print( out, r );
            return;
        }

        for ( int i = start; i < n; ++i ) {
            if ( !visited[ i ] ) {
                visited[ i ] = true;
                out[ depth ] = arr[ i ];
                permutation( depth + 1, n , r, i + 1 );
                visited[ i ] = false;
            }
        }
    }

    private static void print( int[] out, int r ) throws IOException {
        for ( int i = 0; i < r; ++i ) {
            bw.write( out[ i ] + " " );
        }
        bw.write( '\n' );
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        bw = new BufferedWriter( new OutputStreamWriter( System.out ) );


        String[] line = br.readLine().split( " " );

        while( Integer.parseInt( line[ 0 ] ) != 0 ) {

            int n = Integer.parseInt( line [ 0 ] );
            int r = 6;

            init( n, line );

            permutation( 0, n, r, 0 );
            bw.write( '\n' );

            line = br.readLine().split( " " );
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
