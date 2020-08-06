import java.io.*;
import java.awt.Point;
import java.util.Stack;

public class Main {
    public static int[] boardX = { -1, 1, 0, 0, -1, -1, 1, 1 };
    public static int[] boardY = { 0, 0, -1, 1, -1, 1, -1, 1 };
    public static boolean[][] visited;
    public static int[][] board;
    public static int n,m;

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        String[] line = br.readLine().split( " " );
        n = Integer.parseInt( line[ 0 ] );
        m = Integer.parseInt( line[ 1 ] );

        board = new int[ n ][ m ];
        visited = new boolean[ n ][ m ];

        for ( int i = 0; i < n; ++i ) {
            line = br.readLine().split( " " );
            for ( int j = 0; j < m; ++j ) {
                board[ i ][ j ] = Integer.parseInt( line[ j ] );
            }
        }
        // end input

        int cnt = 0;
        for ( int i = 0; i < n; ++i ) {
            for ( int j = 0; j < m; ++j ) {
                if ( board[ i ][ j ] == 1 && !visited[ i ][ j ] ) {
                    cnt = cnt + 1;
                    DFS( i , j );
                }
            }
        }

        System.out.println( cnt );

    }

    public static void DFS( int x, int y ) {
        visited[ x ][ y ] = true;
        for ( int i = 0; i < 8; ++i ) {
            int newX = x + boardX[ i ];
            int newY = y + boardY[ i ];

            if( newX >= 0 && newY >= 0 && newX < n && newY < m ) {
                if( board[ newX ][ newY ] == 1 && !visited[ newX ][ newY ] ) {
                    DFS( newX, newY );
                }
            }
        }
    }

    public static void main( String[] args ) throws IOException {
        solve();
    }
}
