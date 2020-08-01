import java.io.*;

public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        int T = Integer.parseInt( br.readLine() );

        while ( T-- > 0 ) {

            String[] line = br.readLine().split( " " );

            int w = Integer.parseInt( line[ 0 ] );  // 쓰레기 차의 용량
            int n = Integer.parseInt( line[ 1 ] );  // 지점의 개수

            int[] x_i = new int[ n ];
            int[] w_i = new int[ n ];

            for ( int i = 0; i < n; ++i ) {
                line = br.readLine().split( " " );

                x_i[ i ] = Integer.parseInt( line[ 0 ] );
                w_i[ i ] = Integer.parseInt( line[ 1 ] );

            } // end input

            // logic
            int capacity = 0;
            int move = 0;

            for ( int i = 0; i < n; ++i ) {
                if ( w_i[ i ] + capacity > w ) {
                    move = move + ( x_i[ i ] * 2 );
                    capacity = 0;
                }
                capacity = capacity + w_i [ i ];

                if ( i == n - 1 || capacity == w ) {
                    move = move + ( x_i[ i ] * 2 ) ;
                    capacity = 0;
                }
            }
            bw.write( move + "\n" );
        } // end while
        bw.flush();
        bw.close();
        br.close();
    }
}
