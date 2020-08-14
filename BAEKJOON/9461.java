import java.io.*;

public class Main {
    public static long[] dp = new long[ 101 ];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        dp[ 0 ] = 0;
        dp[ 1 ] = dp[ 2 ] = dp[ 3 ] = 1;
        for ( int i = 4; i <= 100; ++i ) {
            dp[ i ] = dp[ i - 2 ] + dp[ i - 3 ];
        }

        int testCase = Integer.parseInt( br.readLine() );

        while( testCase-- > 0 ) {
            int num = Integer.parseInt( br.readLine() );

            bw.write( dp[ num ] + "\n" );

        } // end while
        bw.flush();
        bw.close();
        br.close();

    }
}
