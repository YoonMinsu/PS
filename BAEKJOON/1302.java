import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int testCase = Integer.parseInt( br.readLine() );

        String[] book = new String[ testCase ];

        for ( int i = 0; i <testCase; ++i ) {
            String name = br.readLine();

            book[ i ] = name;
        }

        Arrays.sort( book );

        int count = 0;
        int max = 0;
        String ans = "";
        String temp = book[ 0 ];
        for ( int i = 0; i < testCase; ++i ) {

            if( book[ i ].equals( temp ) ) {
                count++;
            } else {
                if ( count > max ) {
                    max = count;
                    ans = temp;
                }
                temp = book[ i ];
                count = 1;
            }
        }

        if( count > max ) {
            ans = temp;
        }

        System.out.println( ans );

    }
}
