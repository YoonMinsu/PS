import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int MAX = 4_000_001;
    public static List<Integer> list;

    public static void eratos() {
        boolean[] isPrime = new boolean[ MAX ];

        isPrime[ 0 ] = isPrime[ 1 ] = true;
        int rootSqrt = ( int )Math.sqrt( MAX );

        for ( int i = 2; i <= rootSqrt; ++i ) {
            if( isPrime[ i ] ) { continue; }
            for ( int j = i * i; j < MAX; j += i) {
                isPrime[ j ] = true;
            }
        } // end for

        list = new ArrayList<Integer>();
        for ( int i = 2; i < MAX; ++i ) {
            if( !isPrime[ i ] ) {
                list.add( i );
            }
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int num = Integer.parseInt( br.readLine() );

        eratos();

        int sum = 0, cnt = 0;
        int  p1 = 0,  p2 = 0;

        while ( true ) {
            if ( sum >= num ) {
                sum = sum - list.get( p1++ );
            } else if ( p2 == list.size() ) {
                break;
            } else {
                sum = sum + list.get( p2++ );
            }

            if ( sum == num ) {
                cnt++;
            }
        } // end whilt

        System.out.println( cnt );


    }
}
