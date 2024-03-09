package day7;

import java.util.LinkedList;
import java.util.Queue;

public class Question10 {

    // https://cote.inflearn.com/contest/10/problem/07-10
    Node10 root;
    public int BFS(Node10 root) {
        Queue<Node10> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node10 cur = Q.poll();
                if (cur.lt == null && cur.rt == null) {
                    return L;
                }
                if (cur.lt != null) Q.offer(cur.lt);
                if (cur.rt != null) Q.offer(cur.rt);
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) {
        Question10 T = new Question10();
        T.root = new Node10(1);
        T.root.lt = new Node10(2);
        T.root.rt = new Node10(3);
        T.root.lt.lt = new Node10(4);
        T.root.lt.rt = new Node10(5);

        // (이진트리) 말단노드까지의 가장 짧은 경로 ( BFS )
        System.out.println(T.BFS(T.root));
    }
}

class Node10{
    int data;
    Node10 lt, rt;

    public Node10(int val) {
        data = val;
        lt = rt = null;
    }
}

