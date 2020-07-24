import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static int solution( String str, int index, char flag ) {
        if( str.length() == index ) {
            return 1;
        }

        char start = ( str.charAt(index) == 'c' ? 'a' : '0' );
        char end   = ( str.charAt(index) == 'c' ? 'z' : '9' );
        int total = 0;

        for ( char i = (char)start; i <= end; ++i ) {

            if( i != flag ) {
                total += solution( str, index + 1, i );
            }
        }


        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));


        String str = br.readLine();

        System.out.println( solution( str, 0, ' '));

    }
}
