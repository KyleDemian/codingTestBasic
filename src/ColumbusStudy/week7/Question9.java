package ColumbusStudy.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question9 {

    // https://www.acmicpc.net/problem/1991
    static class Node{
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] tree = new Node[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            if (tree[a - 'A'] == null) {
                tree[a - 'A'] = new Node(a);
            }

            if (b != '.') {
                if(tree[b - 'A'] == null) {
                    tree[b - 'A'] = new Node(b);
                }
                tree[a - 'A'].left = tree[b - 'A'];
            }

            if (c != '.') {
                if(tree[c - 'A'] == null) {
                    tree[c - 'A'] = new Node(c);
                }
                tree[a - 'A'].right = tree[c - 'A'];
            }
        }

        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
    }

    private static void preOrder(Node node) {
        System.out.print(node.data);
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);
    }

    private static void inOrder(Node node) {
        if (node.left != null) inOrder(node.left);
        System.out.print(node.data);
        if (node.right != null) inOrder(node.right);
    }

    private static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        System.out.print(node.data);
    }
}
