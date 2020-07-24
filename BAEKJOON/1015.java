import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class Number {
    public int num;
    public int index;

    public Number() {}

    public Number( int num, int index ) {
        this.num = num;
        this.index = index;
    }

}
public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
        int size = Integer.parseInt( br.readLine() );
        int[] p = new int[ 1001 ];
        Number[] numbers = new Number[ size ];

        String[] line = br.readLine().split( " " );
        for ( int i = 0; i < size; ++i ) {
           numbers[ i ] = new Number( Integer.parseInt( line[ i ] ), i );
        }

        Arrays.sort(numbers, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                if ( o1.num < o2.num ) {
                    return -1;
                } else if ( o1.num > o2.num ) {
                    return 1;
                } else {
                    if ( o1.index < o2.index ) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        for ( int i = 0; i < size; ++i ) {
            p[ numbers[ i ].index ] = i;
        }

        for ( int i = 0 ; i < size; ++i ) {
            bw.write( p[ i ] + " " );
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
