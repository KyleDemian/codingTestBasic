package day7;

import java.util.LinkedList;
import java.util.Queue;

public class Question7 {
    // 2~3번 더 들어볼것...... ㅜ
    // https://cote.inflearn.com/contest/10/problem/07-07

    Node8 root;
    public void BFS(Node8 root) {
        Queue<Node8> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Node8 current = Q.poll();
                System.out.print(current.data + " ");
                if (current.lt != null) {
                    Q.offer(current.lt);
                }
                if (current.rt != null) {
                    Q.offer(current.rt);
                }
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Question7 T = new Question7();
        T.root = new Node8(1);
        T.root.lt = new Node8(2);
        T.root.rt = new Node8(3);
        T.root.lt.lt = new Node8(4);
        T.root.lt.rt = new Node8(5);
        T.root.rt.lt = new Node8(6);
        T.root.rt.rt = new Node8(7);
        T.BFS(T.root);

        // 이진트리 레벨 탐색 ( 넓이 우선 탐색 : BFS (레벨탐색) )
    }
}

class Node7{
    int data;
    Node8 lt, rt;

    public Node7(int val) {
        data = val;
        lt = rt = null;
    }
}
