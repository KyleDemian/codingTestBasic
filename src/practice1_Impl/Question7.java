package practice1_Impl;

import java.util.*;

public class Question7 {

    public int solution(int[] keypad, String password){
        int answer = 0;
        // 8 방향
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        // 원래 패스워드
        int[][] pad = new int[3][3];

        // 이동시간
        int[][] dist = new int[10][10];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                pad[i][j] = keypad[i*3 + j];
            }
        }

        // 전부 2초가 걸리도록 채움
        for(int i = 0; i < 10; i++){
            Arrays.fill(dist[i], 2);
        }

        // 자기 자신은 0초
        for(int i = 0; i < 10; i++) dist[i][i] = 0;

        // 인접한 숫자끼리는 1초걸리도록 변경
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int from = pad[i][j];
                for(int k = 0; k < 8; k++){
                    if(i+dx[k] >= 0 && i+dx[k] < 3 && j+dy[k] >= 0 && j+dy[k] < 3){
                        int to = pad[i+dx[k]][j+dy[k]];
                        dist[from][to] = 1;
                    }
                }
            }
        }

        //
        for(int i = 1; i < password.length(); i++){
            int from = (int)password.charAt(i-1)-48;
            int to = (int)password.charAt(i)-48;
            answer += dist[from][to];
        }
        return answer;
    }

    public static void main(String[] args){
        Question7 T = new Question7();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
