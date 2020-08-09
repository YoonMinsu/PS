import java.io.*;

class Solve {
    private static final int[] dx = { 0, 0, -1, 1 };
    private static final int[] dy = { 1, -1, 0, 0 };

    private static int n;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int cntRGB, cntRB;
        n = Integer.parseInt( br.readLine() );
        char[][] board = new char[ n ][ n ];

        board = initBoard( board, br );
        cntRGB = getCnt( board, "RGB" );

        board = initBoard( board );
        cntRB = getCnt( board, "RB" );

        System.out.print( cntRGB + " " + cntRB );
        br.close();
    }

    private char[][] initBoard( char[][] board, BufferedReader br ) throws IOException {
        for ( int i = 0; i < n; ++i ) {
            String line = br.readLine();
            for ( int j = 0; j < n; ++j ) {
                board[ i ][ j ] = line.charAt( j );
            }
        } // end for
        return board;
    }

    private char[][] initBoard( char[][] board )  {
        for ( int i = 0; i < n; ++i ) {
            for ( int j = 0; j < n; ++j ) {
                if( board[ i ][ j ] == 'G' ) {
                    board[ i ][ j ] = 'R';
                }
            }
        } // end for
        return board;
    }

    private int getCnt( char[][] board, String str ) {
        int cnt = 0, length = str.length();
        for ( int i = 0; i < length; ++i ) {
            char flag = str.charAt( i );
            cnt = cnt + getArea( board, flag );
        }
        return cnt;
    }

    private int getArea( char[][] board, char flag ) {
        int length = n, cnt = 0;
        boolean[][] visited = new boolean[ length ][ length ];

        for ( int x = 0; x < length; ++x ) {
            for ( int y = 0; y < length; ++y ) {
                if ( !visited[ x ][ y ] && board[ x ][ y ] == flag ) {
                    cnt = cnt + 1;
                    DFS( board, visited, flag, x, y );
                }
            }
        } // end for
        return cnt;
    }


    private void DFS( char[][] board, boolean[][] visited, char flag, int x, int y ) {
        visited[ x ][ y ] = true;

        for ( int i = 0; i < 4; ++i ) {
            int nextX = x + dx[ i ];
            int nextY = y + dy[ i ];

            if ( nextX >= 0 && nextY >= 0 && nextX < n && nextY < n ) {
                if ( !visited[ nextX ][ nextY ] && board[ nextX ][ nextY ] == flag ) {
                    DFS( board, visited, flag, nextX, nextY );
                }
            }
        } // end for
    }

    public void run() throws IOException {
        solution();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solve().run();
    }
}
