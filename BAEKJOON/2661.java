import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static int len;

    public static void solution( String str ) {
        if( str.length() == len ) {
            System.out.println( str );
            System.exit(0);
        }

        for ( int i = 1; i <= 3; ++i ) {
            if( isCheck( str + i ) ) {
                solution( str + i );
            }
        }
    }

    private static boolean isCheck( String str ) {
        int len = str.length() / 2;

        for ( int i = 1; i <= len; ++i ) {

            String a = str.substring( str.length() - i );
            String b = str.substring( str.length() - 2 * i, str.length() - i );
            System.out.println( "str : " + str );
            System.out.println( "a : " + a + "\t" + " b : " + b  + "\n" );

            if( a.equals( b ) ) {
                return false;
            }
        }

        return true;
    }

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        len = Integer.parseInt( br.readLine() );

        solution("" );

    }
}
