import java.io.*;

public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        String[] line = br.readLine().split( " " );

        int n = Integer.parseInt( line[ 0 ] );
        int m = Integer.parseInt( line[ 1 ] );

        int[] arr = new int[ n + 1 ];
        line = br.readLine().split( " " );

        for ( int i = 1; i <= n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i - 1 ] );
        }

        long ans = 0, temp = 0;
        for ( int i = 1; i <= m; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i - 1 ] );
            temp = temp + arr[ i ];
        }

        ans = temp;
        for ( int i = m + 1; i <= n; ++i ) {
            temp = temp + arr[ i ] - arr[ i - m ];
            ans = Math.max( ans, temp );
        }
        System.out.println( ans );
    }
}
