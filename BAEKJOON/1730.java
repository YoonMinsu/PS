import java.io.*;

public class Main {
    public static int size;
    public static int x,y;
    public static char[][] board;

    /* 보드 초기화 */
    public static void initBoard() {
        board = new char[ size ][ size ];

        for ( int i = 0; i < size; ++i ) {
            for ( int j = 0; j < size; ++j ) {
                board[ i ][ j ] = '.';
            }
        } // end for
    }

    /* 보드 출력 */
    public static void printBoard() throws IOException {
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
        for ( int i = 0; i < size; ++i ) {
            for ( int j = 0; j < size; ++j ) {
                bw.write( board[ i ][ j ] );
            }
            bw.write( '\n' );
        } // end for
        bw.flush();
        bw.close();
    }

    /**
     *
     * @param word
     * U: 위로 | D: 아래 | L: 왼쪽 | R: 오른쪽
     * 시작점은 항상 board의 왼쪽 맨위의 꼭짓점 ( x = 0, y = 0 )
     * 격자 바깥으로 나가도록 하는 움직임 명령이면 무시하고 다음 명령
     * 수직 '|', 수평 '-', 수직수평 = '+'
     */
    public static void drawBoard( char word ) {

        switch ( word ) {
            case 'D' :
                if ( x + 1 < size ) {
                    if ( board[ x ][ y ] == '-' ) {
                        board[ x ][ y ] = '+';
                    } else if ( board[ x ][ y ] == '.' ) {
                        board[ x ][ y ] = '|';
                    }
                    x++;
                    if ( board[ x ][ y ] == '-' ) {
                        board[ x ][ y ] = '+';
                    } else if ( board[ x ][ y ] == '.' ) {
                        board[ x ][ y ] = '|';
                    }
                } // end D
                break;
            case 'L' :
                if ( y - 1 >= 0 ) {
                    if ( board[ x ][ y ] == '|' ) {
                        board[ x ][ y ] = '+';
                    } else if ( board[ x ][ y ] == '.' ) {
                        board[ x ][ y ] = '-';
                    }
                    y--;
                    if ( board[ x ][ y ] == '|' ) {
                        board[ x ][ y ] = '+';
                    } else if ( board[ x ][ y ] == '.' ) {
                        board[ x ][ y ] = '-';
                    }
                } // end L
                break;
            case 'R' :
                if ( y + 1 < size ) {
                    if ( board[ x ][ y ] == '|' ) {
                        board[ x ][ y ] = '+';
                    } else if ( board[ x ][ y ] == '.' ) {
                        board[ x ][ y ] = '-';
                    }
                    y++;
                    if ( board[ x ][ y ] == '|' ) {
                        board[ x ][ y ] = '+';
                    } else if ( board[ x ][ y ] == '.' ) {
                        board[ x ][ y ] = '-';
                    }
                } // end R
                break;
            case 'U' :
                if ( x - 1 >= 0 ) {
                    if ( board[ x ][ y ] == '-' ) {
                        board[ x ][ y ] = '+';
                    } else if ( board[ x ][ y ] == '.' ) {
                        board[ x ][ y ] = '|';
                    }
                    x--;
                    if ( board[ x ][ y ] == '-' ) {
                        board[ x ][ y ] = '+';
                    } else if ( board[ x ][ y ] == '.' ) {
                        board[ x ][ y ] = '|';
                    }
                } // end U
                break;
        } // end switch
    }

    /* 해결 */
    public static void solution( String cmd, int length ) {
        for ( int i = 0; i < length; ++i ) {
            char word = cmd.charAt( i );
            drawBoard( word );
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        size = Integer.parseInt( br.readLine() );
        String cmd = br.readLine();
        int length = cmd.length();

        initBoard();

        solution( cmd, length );

        printBoard();


        br.close();

    }
}
