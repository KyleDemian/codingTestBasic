package ColumbusStudy.week7_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question6 {

    // https://www.acmicpc.net/problem/13023
    // 복습 완 ( 사용자 ABCDE 가 친구다 라고 문제를 생각하고 접근해야 함 ) N-1 명이 친구가 아님,
    static int N, M;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static boolean checked = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[N];

        // 0 1 2 3 4 까지 저장하니까 N 전까지
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        // A - B - C - D - E 의 관계이기때문에 설정 -> 유니온앤파인드를 써야할지 사실조금 햇갈림.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 0);
            if (checked) {
                System.out.print(1);
                return;
            }
        }

        // 관계가 없을때,
        System.out.print(0);
    }

    // ABCDE가 -> idx 01234 순으로 매칭,
    static void DFS(int idx, int depth) {
        if (checked) return;
        if (depth == 4) {
            checked = true;
            return;
        }

        // 0 번째 사람.
        visited[idx] = true;

        // 최초에 0 , friend -> 1 -> false
        for (int friend : list.get(idx)) {
            if (!visited[friend]) {
                DFS(friend, depth + 1);
            }
        }

        visited[idx] = false;
    }
//    static int n, m;
//    static ArrayList<Integer>[] arr;
//    static boolean[] visited;
//    static boolean checked = false;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        arr = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = new ArrayList<>();
//        }
//        visited = new boolean[n];
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            arr[a].add(b);
//            arr[b].add(a);
//        }
//
//        for (int i = 0; i < n; i++) {
//            DFS(i, 0);
//            if (checked) {
//                System.out.println(1);
//                return;
//            }
//        }
//        System.out.println(0);
//    }
//
//    static void DFS(int idx, int depth) {
//        if(checked) return;
//        if (depth == 4) {
//            checked = true;
//            return;
//        }
//
//        visited[idx] = true;
//
//        // idx와 연결된 노드에 대해서만 재귀적으로 DFS를 호출
//        for (int friend : arr[idx]) {
//            if(!visited[friend]) {
//                DFS(friend, depth + 1);
//            }
//        }
//
//        visited[idx] = false;
//    }

}
