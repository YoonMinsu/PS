import java.io.*;


public class Main {
    public static long[][] arr = new long[ 31 ][ 31 ];

    public static void pascal() {
        arr[ 1 ][ 1 ] = 1;
        arr[ 2 ][ 1 ] = arr[ 2 ][ 2 ] = 1;

        for ( int i = 3; i <= 30; ++i ) {
            arr[ i ][ 1 ] = arr[ i ][ i ] = 1;
            for ( int j = 2; j <= i - 1; ++j ) {
                arr[ i ][ j ] = arr[ i - 1 ][ j - 1 ] + arr[ i - 1 ][ j ];
            }
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        String[] line = br.readLine().split( " " );

        pascal();

        int n = Integer.parseInt( line[ 0 ] );
        int m = Integer.parseInt( line[ 1 ] );

        System.out.println( arr[ n ][ m ] );
    }
}
