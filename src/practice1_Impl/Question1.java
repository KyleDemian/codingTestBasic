package practice1_Impl;

import java.util.*;

public class Question1 {

    // 시뮬레이션 & 구현
    // 배열의 이동

    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        // A, B, C, D, E 를 셋팅
        for (int i = 0; i < n; i++) {
            answer[i] = (char) (i + 'A');
        }

        for (int[] line : ladder) { // 배열 방값 1,2,3 값을 가지고 옴
            for (int x : line) {    // 배열 방안의 값을 확인 ex , {1, 3}
                // n+1 배열은 0부터 시작이니
                // 1이라면, 2번과 1번값이 연결됌,
                // 3이라면 4번과 3번값이 연결됌
                char tmp = answer[x];
                answer[x] = answer[x - 1];
                answer[x - 1] = tmp;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Question1 T = new Question1();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
