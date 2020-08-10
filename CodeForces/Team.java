import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );

        int cnt = 0;
        for ( int i = 0; i < n; ++i ) {
            String[] line = br.readLine().split( " " );
            int petaya = Integer.parseInt( line[ 0 ] );
            int vasya  = Integer.parseInt( line[ 1 ] );
            int tonya  = Integer.parseInt( line[ 2 ] );

            int flag = petaya + vasya + tonya;
            if ( flag >= 2 ) {
                cnt = cnt + 1;
            }
        }

        System.out.println( cnt );

    }
}
