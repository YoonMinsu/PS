import java.io.*;

class BaekJoon_2631 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( br.readLine() );

        int[] dp = new int[ n + 1 ];

        int maxLength = 0;
        // dp[ i ] = i 번호일때까지 연속된 증가수열의 개수
        // dp[ i ] = dp[ i - 1 ] + 1;
        String[] list = br.readLine().split( " " );
        for ( int i = 0; i < n; ++i ) {
            int num = Integer.parseInt( list[ i ] );
            dp[ num ] = dp[ num - 1 ] + 1;
            maxLength = Math.max( maxLength, dp[ num ] );
        }

        System.out.println( n - maxLength);
    }

    public void run() throws IOException {
        solution();
    }
}

public class Main {
    public static void main( String[] args ) throws IOException {
        new BaekJoon_2631().run();
    }
}
