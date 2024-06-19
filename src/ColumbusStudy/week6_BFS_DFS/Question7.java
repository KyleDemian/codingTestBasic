package ColumbusStudy.week6_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question7 {

    // https://www.acmicpc.net/problem/11725
    static int N;
    static ArrayList<ArrayList<Integer>> list;
    static int[] ch, parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list  = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N ; i++){
            list.add(new ArrayList<>());
        }

        ch = new int[N+1];
        parents = new int[N+1];

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        // 시작노드는 1이라고 함.
        BFS(1);

        for(int i = 2; i <= N; i++){
            System.out.println(parents[i]);
        }
    }

    static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        ch[node] = 1;    // 현재 노드는 사용했다고 체크,

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i : list.get(tmp)){
                if(ch[i] != 1){
                    q.offer(i);
                    parents[i] = tmp;
                    ch[i] = 1;
                }
            }
        }

    }
}
