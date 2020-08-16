import java.io.*;
import java.util.*;

class Pair {
    int left;
    int right;

    public Pair( int left, int right ) {
        this.left = left;
        this.right = right;
    }
}

class Point {
    int index;
    int value;

    public Point( int index, int value ) {
        this.index = index;
        this.value = value;
    }
}

class BaekJoon_2568 {

    private int lower_bound( int[] dp, int end, int key ) {
        int start = 0;
        while ( start < end ) {
            int mid = ( start + end ) / 2;
            if( dp[ mid ] < key ) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private void printResult( Pair[] pole, int num ) {
        int[] dp = new int[ num ];
        Point[] tracking = new Point[ num ];

        dp[ 0 ] = pole[ 0 ].left;
        tracking[ 0 ] = new Point( 0, pole[ 0 ].left );

        int idx = 0;
        for ( int i = 1; i < num; ++i ) {
            if ( dp[ idx ] < pole[ i ].left ) {
                dp[ ++idx ] = pole[ i ].left;
                tracking[ i ] = new Point( idx, pole[ i ].left );
            } else {
                int newIdx = lower_bound( dp, idx, pole[ i ].left );
                dp[ newIdx ] = pole[ i ].left;
                tracking[ i ] = new Point( newIdx, pole[ i ].left );
            }
        } // end for

        int minCnt = num - ( idx + 1 );
        System.out.println( minCnt );

        int temp = idx;
        Stack<Integer> stack = new Stack<>();
        for ( int i = num - 1; i >= 0; --i ) {
            if ( temp == tracking[ i ].index ) {
                temp--;
                continue;
            } else {
                stack.push( tracking[ i ].value );
            }
        } // end for
        List<Integer> print = new ArrayList<>();
        while ( !stack.isEmpty() ) {
            print.add( stack.pop() );
        }

        Collections.sort( print );
        for ( int value : print ) {
            System.out.println( value );
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int num = Integer.parseInt( br.readLine() );

        Pair[] pole = new Pair[ num ];
        for ( int i = 0; i < num; ++i ) {
            String[] list = br.readLine().split( " " );
            int left  = Integer.parseInt( list[ 0 ] );
            int right = Integer.parseInt( list[ 1 ] );
            pole[ i ] = new Pair( left, right );
        } // end for

        Arrays.sort(pole, new Comparator<Pair>() {

            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare( o1.right, o2.right );
            }
        });

        printResult( pole, num );

    }

    public void run() throws IOException {
        solution();
    }
}

public class Main {
    public static void main( String[] args ) throws IOException {
        new BaekJoon_2568().run();
    }
}
