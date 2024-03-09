package day7;

import java.util.ArrayList;
import java.util.Scanner;

public class Question12 {
    // https://cote.inflearn.com/contest/10/problem/07-01

    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;    // 방문 했는지 확인
    public void DFS(int v) {
        if (v == n) {
            answer++;
        } else{
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question12 T = new Question12();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;  // 출발점

        // 경로 탐색 ( 인접 리스트 )
        // 5 9
        // 1 2
        // 1 3
        // 1 4
        // 2 1
        // 2 3
        // 2 5
        // 3 4
        // 4 2
        // 4 5
        T.DFS(1);
        System.out.println(answer);
    }
}
