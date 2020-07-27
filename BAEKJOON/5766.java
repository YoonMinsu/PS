import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        ArrayList<Point> list;
        String[] line = br.readLine().split( " " );

        int n = Integer.parseInt( line[ 0 ] );
        int m = Integer.parseInt( line[ 1 ] );

        while ( !( n == 0 && m == 0 ) ) {
            int[] player = new int[ 10_001 ];
            list = new ArrayList<>();

            for ( int i = 0; i < n; ++i ) {
                line = br.readLine().split( " " );
                for ( int j = 0; j < m; ++j ) {
                    int number = Integer.parseInt( line[ j ] );
                    player[ number ]++;
                }
            } // end input

            for ( int i = 0; i < 10001; ++i ) {
                if ( player[ i ] != 0 ) {
                    list.add( new Point( player[ i ], i ) );
                }
            }

            Collections.sort(list, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return Integer.compare( o2.x, o1.x );
                }
            });

            int size = list.size();

            Point now;
            int flag = list.get( 1 ).x;
            int count = 0;
            for ( int i = 1; i < size; ++i ) {
                now = list.get( i );
                if( now.x == flag ) {
                    count++;
                }
            }

            for ( int i = 1; i <= count; ++i ) {
                bw.write( list.get( i ).y + " " );
            }
            bw.write( '\n' );
            bw.flush();

            line = br.readLine().split( " " );
            n = Integer.parseInt( line[ 0 ] );
            m = Integer.parseInt( line[ 1 ] );
        } // end while
        bw.close();
        br.close();
    }
}
