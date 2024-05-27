package ColumbusStudy.week6_BFS_DFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question2 {
    // https://www.acmicpc.net/problem/1325
    // https://smartpro.tistory.com/23 참고
    // 암튼 다 틀렸음.. 포기... 패스 -_-..
    // dfs/bfs 방법이 있습니다. 할 수 있다면 인접배열 + 메모이제이션으로도 풀 수 있을 것으로 보입니다.
    // dfs는 탐색 과정에서 다시 돌아오는 등 중복 방문이 있을 수 있기 때문에 시간 초과가 굉장히 발생하기 쉽습니다.
    // 따라서 bfs를 권장합니다.
    // 어떻게해도.. 시간초과를 피할수가 없네...
    // 실버 2??

    static int N, M;
    static ArrayList <Integer>[] arr;
    static boolean isVisited[];
    static int max;
    static int cntArr[];

    static void DFS(int start) {
        isVisited[start] = true;
        for (int i : arr[start]) {
            if (isVisited[i]) continue;
            cntArr[i]++; // i가 해킹할 수 있는 숫자 증가
            DFS(i);
        }
    }

    static void BFS(int start) {
        Queue<Integer> que = new ArrayDeque<Integer>();

        que.add(start);
        isVisited[start] = true;

        while(!que.isEmpty()) {
            int now = que.poll();
            for (int i : arr[now]) {
                if (isVisited[i]) continue;
                cntArr[i]++; // i가 해킹할 수 있는 숫자 증가
                isVisited[i] = true;
                que.add(i);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];
        cntArr = new int[N+1];

        // 신뢰 관계 입력
        arr = new ArrayList[N+1];
        for (int i=0; i<N+1; i++) arr[i] = new ArrayList <Integer>();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b); // a가 b를 신뢰, a는 b에게 해킹 당할 수 있음
        }

        // 1번부터 N번까지 search
        for (int i=1; i<N+1; i++) {
            isVisited = new boolean[N+1];
            //DFS(i); // 메모리↓ 시간↑
            BFS(i); // 메모리↑ 시간↓

        }

        // 해킹할 수 있는 최댓값 찾기
        for (int i=1; i<N+1; i++) {
            if (max<cntArr[i]) max = cntArr[i];
        }

        // 최댓값인 컴퓨터 출력
        for (int i=1; i<N+1; i++) if (max == cntArr[i]) System.out.print(i+" ");
    }
}
