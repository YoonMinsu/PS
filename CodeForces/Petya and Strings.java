import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static  int compareString( char[] first, char[] second ) {
        int result = 0, length = first.length;

        for ( int i = 0; i < length; ++i ) {
            int num1 = getNum( first[ i ] );
            int num2 = getNum( second[ i ] );

            if( num1 == num2 ) {
                continue;
            } else if ( num1 > num2 ) {
                result = 1;
                break;
            } else {
                result = -1;
                break;
            }
        }
        return result;
    }

    private static int getNum( char word ) {
        if ( checkUpper( word ) ) {
            return word - 64;
        } else {
            return word - 96;
        }
    }

    private static  boolean checkUpper( char word ) {
        return word >= 65 && word <= 90;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        char[] first  = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        int answer = compareString( first, second );
        System.out.println( answer );

    }
}
