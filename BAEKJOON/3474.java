import java.io.*;

public class Main {
    //팩토리얼을 구하는 과정에서 곱하는 숫자의 5의 개수를 파악하기만 하면 0의 개수를 파악할 수 있다.
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        int testCase = Integer.parseInt( br.readLine() );

        while( testCase-- > 0 ) {

            int num = Integer.parseInt( br.readLine() );

            long sum = 0L;

            for ( int i = 5; i <= num; i = i * 5 ) {

                sum = sum + ( num / i );

            } // end for

            bw.write( sum + "\n" );

        } // end while
        bw.flush();
        bw.close();
        br.close();
    }
}
