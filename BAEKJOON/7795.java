import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static int solve( Integer[] arrA, Integer[] arrB ) {
        int cnt = 0;
        int size = arrA.length;

        int i = 0;
        int j = 0;

        while ( size-- > 0 ) {

            if ( arrA[ i ] > arrB[ j ] ) {
                cnt = cnt + arrB.length;
            } else {
                for ( int z = arrB.length - 1; z >= 0; --z ) {
                    if ( arrA[ i ] > arrB[ z ] ) {
                        cnt++;
                    } else {
                        break;
                    }
                } // end for
            } // end if
            i++;
        } // end while
        return cnt;
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
        int testCase = Integer.parseInt( br.readLine() );
        for ( int t = 0; t < testCase; ++t ) {
            String[] line = br.readLine().split( " " );
            int n = Integer.parseInt( line[ 0 ] );
            int m = Integer.parseInt( line[ 1 ] );

            Integer[] arrA = new Integer[ n ];
            Integer[] arrB = new Integer[ m ];

            line = br.readLine().split( " " );
            for ( int i = 0; i < n; ++i ) {
                arrA[ i ] = Integer.parseInt( line[ i ] );
            }

            line = br.readLine().split( " " );
            for ( int i = 0; i < m; ++i ) {
                arrB[ i ] = Integer.parseInt( line[ i ] );
            }
            // end input

            Arrays.sort( arrA, Collections.reverseOrder() );
            Arrays.sort( arrB, Collections.reverseOrder() );

            int result = solve( arrA, arrB );
            bw.write( result + "\n" );
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
