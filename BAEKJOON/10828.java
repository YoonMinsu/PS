import java.io.*;
import java.util.Stack;
import java.util.LinkedList;

class BaekJoon_10828 {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<Integer>();
        int num = Integer.parseInt(br.readLine());

        while ( num-- > 0 ) {
            String args = br.readLine();

            if ( args.startsWith( "push " ) ) {
                int val = Integer.parseInt( args.split(" ")[ 1 ] );
                stack.push( val );
            }

            if ( args.equals( "top" ) ) {
                if( stack.isEmpty() ) {
                    bw.write( String.valueOf( -1 ) + "\n" );
                } else {
                    bw.write( String.valueOf( stack.peek() ) + "\n" );
                }
            }

            if ( args.equals( "size" ) ) {
                bw.write( String.valueOf( stack.size() )  + "\n" );
            }

            if ( args.equals( "empty" ) ) {
                if ( stack.isEmpty() ) {
                    bw.write( String.valueOf( 1 )  + "\n" );
                } else {
                    bw.write( String.valueOf( 0 )  + "\n" );
                }
            }

            if ( args.equals( "pop" ) ) {
                if( stack.isEmpty() ) {
                    bw.write( String.valueOf( -1 )  + "\n" );
                } else {
                    bw.write( String.valueOf( stack.pop() )  + "\n" );
                }
            }
        } // end while
        bw.flush();
        bw.close();
        br.close();

    }

    public void run() throws IOException {
        solution();
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
       new BaekJoon_10828().run();
    }
}
