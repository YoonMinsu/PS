import javax.lang.model.element.NestingKind;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void permutation( String[] arr, String[] out, boolean[] visited, int depth, int n, int r, int start ) {
        if ( depth == r ) {
            print( out, r );
            return;
        }

        for ( int i = start; i < n; ++i ) {
            if ( !visited[ i ] ) {
                visited[ i ] = true;
                out[ depth ] = arr[ i ];
                permutation( arr, out, visited,depth + 1, n, r, i + 1 );
                visited[ i ] = false;
            }
        }
    }

    public static boolean check( String str ) {
        if( str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u") ) {
            return true;
        }
        return false;
    }

    public static void print( String[] out, int r ) {
        int vow = 0, cons = 0;
        String ans = "";
        for ( int i = 0; i < r; ++i ) {
            ans += out[ i ];
            if( check( out[ i ] ) ) {
                vow++;
            } else {
                cons++;
            }
        } // end for
        if( vow >= 1 && cons >= 2 ) {
            System.out.println( ans );
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        String[] line = br.readLine().split( " " );

        int n = Integer.parseInt( line[ 1 ] );
        int r = Integer.parseInt( line[ 0 ] );

        boolean[] visited = new boolean[ n ];
        String[] arr = new String[ n ];
        String[] out = new String[ n ];

        line = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            arr[ i ] = line[ i ];
        }

        Arrays.sort( arr );

        permutation( arr, out, visited, 0, n, r, 0 );

    }
}
