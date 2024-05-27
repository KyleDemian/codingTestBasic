package day16;

import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {
        int k = 80;
        // 최소 피로도, 소모 필로도
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(k, dungeons));
    }

    static boolean[] visited;
    static int[][] order;
    static int max;
    static int n;

    static int solution(int k, int[][] dungeons) {
        int answer = -1;
        n = dungeons.length;
        visited = new boolean[n];
        order = new int[n][n];

        permutation(k, dungeons, 0);
        answer = max;
        return answer;
    }

    static void permutation(int k, int[][] dungeons, int depth) {
        if (depth == n) {
            check(k);
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                order[depth] = dungeons[i];
                permutation(k, dungeons, depth+1);
                visited[i] = false;
            }
        }
    }

    static void check(int k){
        int count = 0;
        for (int i = 0; i < n; i++){
            if (k >= order[i][0]){
                k -= order[i][1];
                count++;
            } else {
                break;
            }
        }
        max = Math.max(max, count);
    }
}
