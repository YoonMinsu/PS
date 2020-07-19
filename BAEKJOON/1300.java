import java.io.*;

public class Main {

    public int solution( int n, int k ) {
        int answer = 0;
        int low = 1;
        int high = k;
        int mid = 0, sum = 0;

        while ( low <= high ) {
            mid = ( low + high ) / 2;
            sum = 0;

            for ( int i = 1; i <= n; ++i ) {
                sum = sum + Math.min( mid / i, n );
            }

            if ( sum >= k ) {
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    public static void main( String[] args ) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );
        int k = Integer.parseInt( br.readLine() );

        System.out.println( new Main().solution( n, k ) );
    }

}
