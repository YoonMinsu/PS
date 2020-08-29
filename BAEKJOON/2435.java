import java.io.*;


public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        String[] line = br.readLine().split( " " );
        int n = Integer.parseInt( line[ 0 ] );
        int k = Integer.parseInt( line[ 1 ] );

        line = br.readLine().split( " " );
        int cur = 0;
        for ( int i = 0; i < k; ++i ) {
            cur = cur + Integer.parseInt( line[ i ] );
        }

        int max = cur;
        for ( int i = k; i < n; ++i ) {
            cur = cur - Integer.parseInt( line[ i - k ] );
            cur = cur + Integer.parseInt( line[ i ] );
            max = Math.max( cur, max );
        }

        System.out.println( max );

    }
}
