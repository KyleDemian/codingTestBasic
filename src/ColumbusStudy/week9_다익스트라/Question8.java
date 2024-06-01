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

    static void DFS(int row) {
        if(row == N) {
            result++;
            return;
        } else {
            // 하나의 행에서 가능한 모든 열에 퀸을 배치해보는것이기떄문에 2중포문을 쓰지않음.
            // 여기서 고려해야할것은 level 의 행을 나타내고있고, i는 열을 나타냄
            // Index x -> level 값이 y 값
            // 행의 열값 이라고 생각하고 변수도명도 변경.
            for(int i = 0; i < N; i++) {
                col[row] = i;
                if (possible(row)) {
                    DFS(row + 1);
                }
            }
        }
    }

    private static boolean possible(int row) {
        for(int i = 0; i < row; i++) {
            // 자기 자신의 값 || 대각선 위치의 값
            if(col[i] == col[row] || Math.abs(row - i) == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }
}
