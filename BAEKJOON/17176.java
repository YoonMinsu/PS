import java.io.*;

public class Main {
    public static int[] a = new int[ 53 ];
    public static int[] b = new int[ 53 ];

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        int n = Integer.parseInt( br.readLine() );

        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            int idx = Integer.parseInt( line[ i ] );
            a[ idx ]++;
        }

        char[] str = br.readLine().toCharArray();
        for ( int i = 0; i < n; ++i ) {
            char c = str[ i ];
            if ( c == ' ' ) {
                b[ 0 ]++;
            } else if ( c >= 65 && c <= 90 ) {
                b[ c - 64 ]++;
            } else {
                b[ c - 70 ]++;
            }
        } // end for

        boolean flag = true;

        for ( int i = 0; i < 53; ++i ) {
            if( a[ i ] != b[ i ] ) {
                flag = false;
                break;
            }
        } // end for

        if( flag ) {
            System.out.println( "y" );
        } else {
            System.out.println( "n" );
        }

    }

    public static void main( String[] args ) throws IOException {
        solve();
    }
}
