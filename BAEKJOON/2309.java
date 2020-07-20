import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        int total = 0;
        int less  = 0;

        int[] dwarf = new int[ 9 ];

        for ( int i = 0; i < 9; ++i ) {
            dwarf[ i ] = Integer.parseInt( br.readLine() );
            total = total + dwarf[ i ];
        }

        less = total - 100;


        boolean flag = false;
        for ( int i = 0; i < 8; ++i ) {
            for ( int j = i + 1; j < 9; ++j ) {
                if ( ( dwarf[ i ] + dwarf[ j ] ) == less ) {
                    dwarf[ i ] = dwarf[ j ] = 0;
                    flag = true;
                    break;
                }
            }
            if( flag ) {
                break;
            }
        } // end for


        Arrays.sort( dwarf );

        for ( int i = 2; i < 9; ++i ) {
            bw.write( dwarf [ i ] + "\n" );
        }
        bw.flush();
        bw.close();
    }
}
