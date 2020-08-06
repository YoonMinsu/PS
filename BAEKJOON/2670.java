import java.io.*;


public class Main {

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int N = Integer.parseInt( br.readLine() );

        double[] arr = new double[ N ];
        for ( int i = 0; i < N; ++i ) {
            arr[ i ] = Double.parseDouble( br.readLine() );
        }

        double t = 0;
        double max = 0;
        for ( int i = 0; i < N; ++i ) {
            t = arr[ i ];
            if ( max < t ) {
                max = t;
            }
            for ( int j = i + 1; j < N; ++j ) {
                t = t * arr[ j ];
                if ( max < t ) {
                    max = t;
                }
            }
        } // end for
        System.out.printf("%.3f", max);
    }
}
