import java.util.*;
import java.io.*;

class Node {
    char value;
    Node left, right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BOJ_1991 {
    static Node[] tree;

    // 전위 순회
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (tree[parentValue - 'A'] == null) {
                tree[parentValue - 'A'] = new Node(parentValue);
            }
            if (leftValue != '.') {
                tree[leftValue - 'A'] = new Node(leftValue);
                tree[parentValue - 'A'].left = tree[leftValue - 'A'];
            }
            if (rightValue != '.') {
                tree[rightValue - 'A'] = new Node(rightValue);
                tree[parentValue - 'A'].right = tree[rightValue - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();
    }
}


