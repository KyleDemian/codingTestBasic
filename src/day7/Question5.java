package day7;

import java.util.Scanner;

public class Question5 {

    // https://cote.inflearn.com/contest/10/problem/07-05

    Node root;
    public void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            // 전위
//            System.out.print(root.data + " ");
            DFS(root.lt);
            // 중위
//            System.out.print(root.data + " ");
            DFS(root.rt);
            // 후위
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Question5 T = new Question5();
        T.root = new Node(1);
        T.root.lt = new Node(2);
        T.root.rt = new Node(3);
        T.root.lt.lt = new Node(4);
        T.root.lt.rt = new Node(5);
        T.root.rt.lt = new Node(6);
        T.root.rt.rt = new Node(7);
        T.DFS(T.root);

        // 이진트리 순회 *DFS ( 깊이 우선 탐색 방법 - 부모를 방문하는 순위 )
        // 전위 1 2 4 5 3 6 7
        // 중위 4 2 5 1 6 3 7
        // 후위 4 5 2 6 7 3 1

    }
}

class Node{
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}
