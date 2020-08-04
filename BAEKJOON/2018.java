import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int num = Integer.parseInt( br.readLine() );

        int[] arr = new int[ num + 1 ];
        for ( int i = 1; i <= num; ++i ) {
            arr[ i ] = i;
        }

        int sum = 0, cnt = 0;
        int p1 = 1, p2 = 1;

        while ( true ) {
            if ( sum >= num ) {
                sum = sum - arr[ p1++ ];
            } else if ( p2 == num ) {
                break;
            } else {
                sum = sum + arr[ p2++ ];
            }

            if ( sum == num ) {
                cnt++;
            }
        } // end while
        System.out.println( cnt + 1 );
    }
}
