package ColumbusStudy.week4_그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question11 {

    // https://www.acmicpc.net/problem/1931
    // 복습 완료

     static class Room implements Comparable<Room>{
         int s, e;

         public Room(int s, int e) {
             this.s = s;
             this.e = e;
         }

         @Override
         public int compareTo(Room o) {
             if(this.e == o.e) return this.s - o.s;
             else return this.e - o.e;
         }
     }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();

            rooms.add(new Room(s, e));
        }

        Collections.sort(rooms);

        int used = 0;
        int finished = 0;

        for (Room room : rooms) {
            if (finished <= room.s) {
                used++;
                finished = room.e;
            }
        }

        System.out.println(used);
    }
}
