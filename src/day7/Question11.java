package day7;

import java.util.Scanner;

public class Question11 {
    // https://cote.inflearn.com/contest/10/problem/07-01

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;    // 방문 했는지 확인
    public void DFS(int v) {
        if (v == n) {
            answer++;
        } else{
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question11 T = new Question11();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;  // 출발점

        // 경로 탐색 ( 인접 행렬 )
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
