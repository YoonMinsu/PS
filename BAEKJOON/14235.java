import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
        int num = Integer.parseInt( br.readLine() );

        PriorityQueue<Integer> q = new PriorityQueue<>(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        while ( num-- > 0 ) {

            String[] line = br.readLine().split( " " );

            int size = line.length;

            if ( size == 1  ) {
                if ( !q.isEmpty() ) {
                    bw.write( q.poll() + "\n" );
                } else {
                    bw.write( -1 + "\n");
                }
            } else {
                int cnt = Integer.parseInt( line[ 0 ] );

                for ( int i = 0; i < cnt; ++i ) {
                    q.offer( Integer.parseInt( line[ i + 1 ] ) );
                }
            }
        } // end while
        bw.flush();
        bw.close();
        br.close();

    }
}
