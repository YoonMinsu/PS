import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    private char data;
    private Node leftNode;
    private Node rightNode;

    public Node() {}
    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}

public class Main {
    private static Node root;

    public static void setRoot(Node node) {
        root = node;
    }
    public static Node getRoot() {
        return root;
    }

    public static void creatNode(Node[] nodes, char root, char left, char right) {
        nodes[root - 'A'].setData(root);
        if (left != '.') {
            nodes[root - 'A'].setLeftNode(nodes[left - 'A']);
        }

        if (right != '.') {
            nodes[root - 'A'].setRightNode(nodes[right - 'A']);
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.getData());
            preOrder(root.getLeftNode());
            preOrder(root.getRightNode());
        }
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeftNode());
            System.out.print(root.getData());
            inOrder(root.getRightNode());
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.getLeftNode());
            postOrder(root.getRightNode());
            System.out.print(root.getData());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[size];
        for (int i = 0; i < size; ++i) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < size; ++i) {
            String[] list = br.readLine().split(" ");
            char root = list[0].charAt(0);
            char left = list[1].charAt(0);
            char right = list[2].charAt(0);
            creatNode(nodes, root, left, right );
        }

        setRoot(nodes[0]);
        Node root = getRoot();

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }
}
