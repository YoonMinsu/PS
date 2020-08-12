import java.io.*;

class BaekJoon_11055 {
    private static int arr[] = new int[ 1_001 ];
    private static int dp[] = new int[ 1_001 ];

    private void initArr(int n, BufferedReader br) throws IOException {
        String[] line = br.readLine().split( " " );
        for ( int i = 1; i <= n; ++i ) {
            arr[ i ] = Integer.parseInt( line[ i - 1 ] );
        }
    }

    private int solve(int n, BufferedReader br) throws IOException {

        initArr( n, br );

        for ( int i = 1; i <= n; ++i ) {
            dp[ i ] = arr[ i ];
            for ( int j = 1; j < i; ++j ) {
                if ( arr[ i ] > arr[ j ] && dp[ j ] + arr[ i ] > dp[ i ] ) {
                    dp[ i ] = dp[ j ] + arr[ i ];
                }
            }
        }

        int result = 0;
        for ( int i = 1; i <= n; ++i ) {
            result = Math.max( result, dp[ i ] );
        }

        return result;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int result = solve(num, br);

        bw.write(result+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        new BaekJoon_11055().solution();
    }
}
