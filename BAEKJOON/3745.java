import java.io.*;
import java.util.StringTokenizer;

class BaekJoon_3745 {
    private int lowerBound( int[] dp, int idx, int key ) {
        int start = 0, end = idx;
        while ( start < end ) {
            int mid = ( start + end ) / 2;
            if ( dp[ mid ] < key ) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private int length( int[] nums, int num ) throws IOException {
        int[] dp = new int[ num ];

        dp[ 0 ] = nums[ 0 ];
        int idx = 0;
        for ( int i = 1; i < num; ++i ) {
            if ( dp[ idx ] < nums[ i ] ) {
                dp[ ++idx ] = nums[ i ];
            } else {
                int newIdx = lowerBound( dp, idx, nums[ i ] );
                dp[ newIdx ] = nums[ i ];
            }
        } // end for
        return idx + 1;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

        String line = null;
        while ( ( line = br.readLine() ) != null ) {
            line = line.trim();

            if(line.equals("") || line.length() == 0 ) {
                break;
            }
            int num = Integer.parseInt( line );
            int[] nums = new int[ num ];

            StringTokenizer st = new StringTokenizer( br.readLine().trim() );

            for ( int i = 0; i < num; ++i ) {
                nums[ i ] = Integer.parseInt( st.nextToken() );
            }

            int result = length( nums, num );

            bw.write( result + "\n" );

        } // end while
        bw.flush();
        bw.close();
        br.close();
    }

}
public class Main {
    public static void main( String[] args ) throws IOException {
        new BaekJoon_3745().solution();
    }
}
