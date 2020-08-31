import java.io.*;
class Node {
    public int data;
    public Node leftNode;
    public Node rightNode;

    public Node(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
}
public class Main {
    private static Node root;

    public static void insertNode(int num) {
        Node newNode = new Node(num);
        if (root == null) {
            root = newNode;
        } else {
            Node cur = root;
            Node parent = null;
            while (true) {
                parent = cur;
                if (num < cur.data) {
                    cur = cur.leftNode;
                    if (cur == null) {
                        parent.leftNode = newNode;
                        return;
                    }
                } else {
                    cur = cur.rightNode;
                    if (cur == null) {
                        parent.rightNode = newNode;
                        return;
                    }
                } // end if
            } // end while
        } // end if
    }

    public static void postOrder(BufferedWriter bw, Node root) throws IOException{
        if (root != null) {
            postOrder(bw, root.leftNode);
            postOrder(bw, root.rightNode);
            bw.write(root.data + "\n");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = "";
        while((num = br.readLine()) != null) {
            int value = Integer.parseInt(num);
            insertNode(value);
        }

        postOrder(bw, root);

        bw.flush();
        bw.close();
    }
}
