package ColumbusStudy.week6_BFS_DFS;

import java.io.*;
import java.util.*;

public class Question1 {
    // https://www.acmicpc.net/problem/2606
    // 복습 완 - 양방향 그래프

    static int n, m , answer = 0;
    static int[] ch;
    static int[][] grape;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        ch = new int[n + 1];
        grape = new int[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            grape[a][b] = 1;
            grape[b][a] = 1;
        }

        DFS(1);

        // -1 이유는 자신을 빼야 하기때문에
        System.out.println(answer - 1);
    }

    public static void DFS(int v){
        answer++;
        ch[v] = 1;
        for (int i = 1; i <= n; i++) {
            if(ch[i] == 0 && grape[v][i] == 1){
                DFS(i);
            }
        }
    }
}
