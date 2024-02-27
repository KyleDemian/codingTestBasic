package day2;

import java.util.*;

public class Question11 {   // 오답이라는데.. 뭐가 틀린지 못찾겠어..

    // https://cote.inflearn.com/contest/10/problem/02-11

    public int solution(int n, int[][] arr) {
        int answer = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {   // 학생번호
            int cnt = 0;
            for (int j = 1; j <= n; j++) { // 학년
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }

            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question11 T = new Question11();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n+1][6];
        for (int i = 1; i <= n; i++) {       // 학생번호
            for (int j = 1; j <= 5; j++) {   // 학생 수
                arr[i][j] = kb.nextInt();
            }
        }

        // 임시 반장 정하기 - 한번이라도 같은많이 가장 많았던 사람 정하기.
        // 5
        // 2 3 1 7 3
        // 4 1 9 6 8
        // 5 5 2 4 4
        // 6 5 2 6 7
        // 8 4 2 2 2
        System.out.println(T.solution(n, arr));
    }
}
