package ColumbusStudy.week6;

import java.io.*;
import java.util.*;

public class Question5 {

    // https://www.acmicpc.net/problem/1260
    // 못풀었음. 문제는 이해가 됐는데.

    static int n, m, v;
    static int[] ch;
    static int[][] grape;
    static String a1 = "", a2 = "";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        ch = new int[n+1];
        grape = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 간선이기때문에
            grape[a][b] = 1;
            grape[b][a] = 1;
        }

        // 4 5 1
        // 1 2
        // 1 3
        // 1 4
        // 2 4
        // 3 4
        // 시작 위치가 v 이기때문에
        d(v);
        System.out.println(a1);
        b(v);
        System.out.println(a2);
        // 1 2 4 3
        // 1 2 3 4

    }

    static void d(int l) {
        // 시작 정점은 방문했기때문에
        ch[l] = 1;
        a1 += l + " ";
        for(int i =1; i <= n; i++){
            if(ch[i] == 0 && grape[l][i] == 1){
                d(i);
            }
        }

    }

    static void b(int l) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        // 시작 정점은 방문했기때문에
        ch[l] = 0;

        while(!q.isEmpty()){
            int tmp = q.poll();
            a2 += tmp + " ";
            for(int i =1; i <= n; i++){
                if(grape[tmp][i] == 1 && ch[i] == 1) {
                    q.offer(i);
                    ch[i] = 0;
                }
            }
        }
    }
}
