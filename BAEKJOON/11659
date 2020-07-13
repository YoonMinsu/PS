import java.io.*;

public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        String[] line = br.readLine().split( " " );

        int N = Integer.parseInt( line[ 0 ] );
        int M = Integer.parseInt( line[ 1 ] );

        int[] arr = new int[ N + 1 ];

        line = br.readLine().split( " " );
        for ( int i = 1; i <= N; ++i ) {
            arr[ i ] = arr[ i - 1 ] + Integer.parseInt( line[ i - 1 ] );
        }

        //arr[b] - arr[a-1]
        while ( M-- > 0 ) {
            line = br.readLine().split( " " );
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            bw.write( arr[b] - arr[a-1] +"\n");
        }
        bw.flush();
        bw.close();
    }
}
