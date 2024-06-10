package ColumbusStudy.week11_기출풀이;

import java.io.*;
import java.util.*;

public class Question1 {

    // https://www.acmicpc.net/problem/20006
    static int p, m;
    static ArrayList<Player> list = new ArrayList<>();
    static Queue<Player> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = Integer.parseInt(st.nextToken());   // 플레이어의 수
        m = Integer.parseInt(st.nextToken());   // 정원

        // 값 입력 받기
        for (int i = 0; i < p; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            list.add(new Player(a, b));
        }

        // 최대 게임수만큼 회전
        for (int i = 0; i < p; i++) {
            ArrayList<Player> rooms = new ArrayList<>();
            // false 일 경우만
            if(!list.get(i).ch){
                for (int j = 0; j < p; j++) {
                    if(rooms.size() == m) break;
                    int lv = list.get(j).level;
                    String name = list.get(j).name;
                    if(!list.get(j).ch && list.get(i).level - 10 <= lv && lv <= list.get(i).level + 10){
                        list.get(j).ch = true;
                        rooms.add(new Player(lv, name));
                    }
                }

                Collections.sort(rooms);

                if (rooms.size() == m) sb.append("Started!").append("\n");
                else sb.append("Waiting!").append("\n");

                for(Player ob: rooms){
                    sb.append(ob.level + " " + ob.name).append("\n");
                }
            }
        }


        System.out.print(sb.toString());
    }

    static class Player implements Comparable<Player>{
        // 레벨, 닉네임
        int level;
        String name;
        boolean ch;

        public Player(int level, String name){
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player ob){
            return name.compareTo(ob.name);
        }
    }
}
