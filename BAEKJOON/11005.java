import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack  = new Stack<>();
        String[] list = br.readLine().split(" ");

        int n = Integer.parseInt(list[0]);
        int b = Integer.parseInt(list[1]);

        int flag = 0;
        while (n > 0) {
            flag = n % b;
            if (flag >= 10) {
                stack.push((char)(flag - 10 + (int)'A'));
            } else {
                stack.push((char)(flag + (int)'0'));
            }
            n = n / b;
        } // end while
        while (!stack.isEmpty()) {
            bw.write(String.valueOf(stack.pop()));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
