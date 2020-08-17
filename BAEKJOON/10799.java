import java.io.*;
import java.util.Stack;

class BaekJoon_9012 {

    private int ironStick( char[] bracket ) {
        Stack<Character> stack = new Stack<Character>();

        int sum = 0;
        int len = bracket.length;
        for ( int i = 0; i < len; ++i ) {
            char c = bracket[ i ];

            if ( c == '(' ) {
                stack.push( c );
            }

            if ( c == ')' ) {
                stack.pop();

                if( bracket[ i - 1 ] == '(' ) {
                    sum = sum + stack.size();
                } else {
                    sum = sum + 1;
                }
            }
        } // end for

        return sum;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] bracket = br.readLine().toCharArray();

        int result = ironStick( bracket );

        bw.write( String.valueOf( result ) );

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
       new BaekJoon_9012().run();
    }
}
