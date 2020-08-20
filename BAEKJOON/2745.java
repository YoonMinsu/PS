import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] list = br.readLine().split(" ");

        String n = list[0];
        int b = Integer.parseInt(list[1]);

        int length = n.length();
        int answer = 0;
        for (int i = 0; i < length; ++i) {
            char num = n.charAt(i);
            if (num >= 'A' && num <= 'Z') {
                answer = answer * b + (num - 'A' + 10);
            } else {
                answer = answer * b + (num - '0');
            }
        } // end for
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}
