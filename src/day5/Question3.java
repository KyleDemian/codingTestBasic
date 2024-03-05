package day5;

import java.util.Scanner;
import java.util.Stack;

public class Question3 {

    // https://cote.inflearn.com/contest/10/problem/05-03 - kakao   // 답이 4라는데.. 왜지..

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {    // 행 ( 가로 ) 크기
                if (board[i][pos-1] != 0) {
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {  // stack.peek ( 맨 위에 있는 값과 비교 )
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Question3 T = new Question3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n];  // 게임판 작성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }

        int m = kb.nextInt();       // 움직일 횟수
        int[] moves = new int[m];   // 게임판 숫자
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }

        // 괄호 개수 확인 - 예시 크레인 인형뽑기 카카오
        // 5
        // 0 0 0 0 0
        // 0 0 1 0 3
        // 0 2 5 0 1
        // 4 2 4 4 2
        // 3 5 1 3 1
        // 8
        // 1 5 3 5 1 2 1 4
        // 4
        System.out.println(T.solution(board, moves));
    }
}
