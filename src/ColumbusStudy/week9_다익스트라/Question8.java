package ColumbusStudy.week9_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question8 {
    // https://www.acmicpc.net/problem/9663

    static int N;
    static int[] col;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];

        DFS(0);
        System.out.println(result);
    }

    static void DFS(int level) {
        if(level == N) {
            result++;
            return;
        } else {
            for(int i = 0; i < N; i++) {
                col[level] = i;
                if (possible(level)) {
                    DFS(level + 1);
                }
            }
        }
    }

    private static boolean possible(int level) {
        for(int i = 0; i < level; i++) {
            if(col[i] == col[level] || Math.abs(level - i) == Math.abs(col[level] - col[i])) {
                return false;
            }
        }
        return true;
    }
}
