import java.io.*;

public class Main {

    public static void main( String[] args ) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

        String[] line = br.readLine().split( " " );
        int n = Integer.parseInt( line[ 0 ] );
        int m = Integer.parseInt( line[ 1 ] );

        int[][] arr = new int[ n + 1 ][ n + 1 ];

        for ( int i = 1; i <= n; ++i ) {
            line = br.readLine().split( " " );
            for ( int j = 1; j <= n; ++j ) {
                arr[ i ][ j ] = arr[ i ][ j - 1 ] + arr[ i - 1 ][ j ] - arr[ i - 1 ][ j - 1 ]
              + Integer.parseInt( line[ j - 1 ] );
            }
        }


        while ( m-- > 0 ) {

            line = br.readLine().split( " " );

            x1 = Integer.parseInt( line[ 0 ] );
            y1 = Integer.parseInt( line[ 1 ] );
            x2 = Integer.parseInt( line[ 2 ] );
            y2 = Integer.parseInt( line[ 3 ] );

            bw.write( arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1] + "\n");

        }
        bw.flush();
        bw.close();
    }
}
