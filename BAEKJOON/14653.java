import java.io.*;

public class Main {

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int[]     arr   = new int[ 10_001 ];
        int[]     count = new int[ 10_001 ];
        boolean[] read  = new boolean[ 26 ];

        String[] line = br.readLine().split( " " );
        int n = Integer.parseInt( line[ 0 ] );
        int k = Integer.parseInt( line[ 1 ] );
        int q = Integer.parseInt( line[ 2 ] );

        for ( int i = 1; i <= k; ++i ) {
            line = br.readLine().split( " " );

            count[ i ] = Integer.parseInt( line[ 0 ] );
            arr[ i ] = line[ 1 ].toCharArray()[ 0 ] - 'A';
        }

        if( count[ q ] == 0 ) {
            System.out.println( -1 );
            return;
        }

        for ( int i = k; i >= q; --i ) {
            read[ arr[ i ] ] = true;
        }

        for ( int i = q; i > 1; --i ) {
            if( count[ i ] != count[ i - 1 ] ) {
                break;
            }
            read[ arr[ i ] ] = true;
            read[ arr[ i - 1 ] ] = true;
        }

        for ( int i = 1; i < n; ++i ) {
            if ( !read[ i ] ) {
                System.out.print( (char)( i + 'A') + " " );
            }
        }
    }
}
