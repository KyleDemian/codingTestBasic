package day16;

import java.util.ArrayList;

public class Question3 {

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(solution(maps));
    }

    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] grape, ch;
    static int n, m;
    static int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        grape = new int[n][m];
        ch = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(maps[i].charAt(j) == 'X'){
                    ch[i][j] = 1;
                } else {
                    grape[i][j] = Integer.parseInt(String.valueOf(maps[i].charAt(j)));
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(ch[i][j] != 1){
                    ch[i][j] = 1;
                    list.add(recursive(i,j));
                }
            }
        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        if(list.isEmpty()) return new int[]{-1};
        return answer;
    }

    static int recursive(int x, int y){
        int sum = grape[x][y];
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && ch[nx][ny] != 1){
                ch[nx][ny] = 1;
                sum += recursive(nx,ny);
            }
        }
        return sum;
    }

}
