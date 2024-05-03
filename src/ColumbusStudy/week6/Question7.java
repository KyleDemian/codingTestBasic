package ColumbusStudy.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question7 {

    // https://www.acmicpc.net/problem/11725

    static ArrayList<Integer>[] list;
    static int[] ch, parents;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        ch = new int[n+1];
        parents = new int[n+1];
        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향
            list[a].add(b);
            list[b].add(a);
        }

        BFS(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        ch[node] = 1;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i : list[tmp]) {
                if(ch[i] != 1 ) {
                    q.offer(i);
                    parents[i] = tmp;
                    ch[i] = 1;
                }
            }
        }
    }
}
