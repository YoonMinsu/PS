import java.io.*;

public class Main {

    public static int[] arr;

    public static void swap( int i , int j ) {
        int temp = arr[ i ];
        arr[ i ] = arr[ j ];
        arr[ j ] = temp;
    }

    public static long calc( int a, int b ) {
        long sum = 0;

        for ( int i = a; i <=b ; ++i ) {
            sum = sum + arr[ i ];
        }
        return sum;
    }

    public static long solve( String[] line ) {
        long answer = 0;
        int flag = Integer.parseInt( line[ 0 ] );

        if( flag == 1 ) {
            int a = Integer.parseInt( line[ 1 ] );
            int b = Integer.parseInt( line[ 2 ] );
            answer = calc( a , b );
            swap( a, b );
            return  answer;
        } else {
            int a = Integer.parseInt( line[ 1 ] );
            int b = Integer.parseInt( line[ 2 ] );
            int c = Integer.parseInt( line[ 3 ] );
            int d = Integer.parseInt( line[ 4 ] );
            answer = calc( a, b ) - calc( c, d );
            return  answer;
        }
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        String[] line = br.readLine().split( " " );

        int n = Integer.parseInt( line[ 0 ] ); // 수열의 길이
        int q = Integer.parseInt( line[ 1 ] ); // 쿼리의 개수

        arr = new int[ n + 1 ];
        line = br.readLine().split( " " );
        for ( int i = 1; i <= n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i - 1 ] );
        }

        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
        while ( q-- > 0 ) {
            line = br.readLine().split( " " );

            long result = solve( line );

            bw.write( result + "\n" );
        } // end while
        bw.flush();
        bw.close();
        br.close();
    }
}
