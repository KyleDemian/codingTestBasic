package ColumbusStudy.week9_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question8 {
    // https://www.acmicpc.net/problem/9663 (필수)

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
            // 하나의 행에서 가능한 모든 열에 퀸을 배치해보는것이기떄문에 2중포문을 쓰지않음.
            // 여기서 고려해야할것은 level 의 행을 나타내고있고, i는 열을 나타냄
            // Index x -> level 값이 y 값
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
            // 자기 자신의 값 || 대각선 위치의 값
            if(col[i] == col[level] || Math.abs(level - i) == Math.abs(col[level] - col[i])) {
                return false;
            }
        }
        return true;
    }
}
