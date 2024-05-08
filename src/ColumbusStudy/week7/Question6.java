package ColumbusStudy.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question6 {

    // https://www.acmicpc.net/problem/13023
    // 기초 세션7 13 -> 경로 탐색 인접 리스트  ( 행렬이 아닌 )
    static int n, m;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean checked = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            DFS(i, 0);
            if (checked) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void DFS(int idx, int depth) {
        if(checked) return;
        if (depth == 4) {
            checked = true;
            return;
        }

        visited[idx] = true;

        // idx와 연결된 노드에 대해서만 재귀적으로 DFS를 호출
        for (int friend : arr[idx]) {
            if(!visited[friend]) {
                DFS(friend, depth + 1);
            }
        }

        visited[idx] = false;
    }

    // 이제 각 노드를 DFS로 탐색하게 됩니다.
    // 노드 0부터 시작해 DFS(0, 0)을 호출하면, 먼저 visited[0]이 true가 되고, depth는 0입니다.
    // arr[0]에 있는 모든 친구 1에 대해 DFS(1, 1)을 호출합니다.
    // visited[1]이 true가 되고, depth는 1입니다. 그럼 arr[1]에 있는 모든 친구 0과 2에 대해 루프를 시작합니다.
    // 0인 친구는 이미 방문했으므로 건너뛰고, 2인 친구에 대해 DFS(2, 2)를 호출합니다.
    // visited[2]이 true가 되고, depth는 2입니다. 그럼 arr[2]에 있는 모든 친구 1과 3에 대해 루프를 시작합니다.
    // 1인 친구는 이미 방문했으므로 건너뛰고, 3인 친구에 대해 DFS(3, 3)을 호출합니다.
    // visited[3]이 true가 되고, depth는 3입니다. 그럼 arr[3]에 있는 모든 친구 2과 4에 대해 루프를 시작합니다.
    // 2인 친구는 이미 방문했으므로 건너뛰고, 4인 친구에 대해 DFS(4, 4)을 호출합니다.
    // visited[4]이 true이고, depth는 4입니다. depth가 4이므로 checked는 true가 되고 DFS 탐색은 끝났습니다.
    // 결국, checked가 true이므로 출력값으로 1이 출력되고 프로그램이 종료됩니다. 이는 5명의 친구가 존재함을 의미합니다.(0-1-2-3-4)

    // ArrayList<ArrayList<Integer>> arr
    // arr.add(new ArrayList<>());
    // arr.get(index).add(element);

    // ArrayList<Integer>[] arr
    // arr[index] = new ArrayList<>();
    // arr[index].add(element);


//    static int n, m;
//    static int[][] arr;
//    static int[] ch;
//    static boolean checked = false;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());   // 총 사람 숫자
//        m = Integer.parseInt(st.nextToken());   // 관계의 숫자
//
//        arr = new int[n][n];
//        ch = new int[n];
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            // a b 가 친구이면, b a 도 친구이다.
//            arr[a][b] = 1;
//            arr[b][a] = 1;
//        }
//
//        for (int i = 0; i < n; i++) {
//            DFS(i, 1);
//            if (checked) {
//                System.out.println(1);
//                return;
//            }
//        }
//        System.out.println(0);
//
//    }
//
//    static void DFS(int idx, int depth) {
//        if(checked) return; // 만족하는 친구 관계가 찾아졌다면, 더 이상의 탐색은 필요 없음
//        if (depth == 5) { // 사람 A,B,C,D,E가 존재하면 depth는 5가 된다 -> m 까지 돌아야하는거 아닌가??
//            checked = true;
//            return;
//        }
//
//        ch[idx] = 1;
//        for (int i = 0; i < n; i++) {
//            if(arr[idx][i] == 1 && ch[i] != 1) { // 해당 지점(i)를 방문한 적이 없고 idx와 i가 친구라면
//                DFS(i, depth + 1); // i를 시작으로 깊이 우선 탐색을 이어감
//            }
//        }
//
//        // 탐색을 마친 노드는 다시 방문 가능하도록 바꿔줌
//        ch[idx] = 0;
//    }
}
