package day7;

import java.util.Scanner;

public class Question9 {

    // https://cote.inflearn.com/contest/10/problem/07-09
    // 최단거리는 BFS로 풀이를 가는게 맞음.
    Node9 root;
    public int DFS(int L, Node9 root) {
        if (root.lt == null && root.rt == null) {
            return L;
        } else {
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }
    }

    public static void main(String[] args) {
        Question9 T = new Question9();
        T.root = new Node9(1);
        T.root.lt = new Node9(2);
        T.root.rt = new Node9(3);
        T.root.lt.lt = new Node9(4);
        T.root.lt.rt = new Node9(5);

        // (이진트리) 말단노드까지의 가장 짧은 경로
        System.out.println(T.DFS(0, T.root));
    }
}

class Node9{
    int data;
    Node9 lt, rt;

    public Node9(int val) {
        data = val;
        lt = rt = null;
    }
}

