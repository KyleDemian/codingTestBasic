package ColumbusStudy.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question11 {

    // https://www.acmicpc.net/problem/1931

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
        // 형식으로 간소화는 가능하지만, 어차피 Room 형태로
        // ArrayList에 담아야하기때문에, 객체도 생성하고, Comparable 인터페이스를
        // 구현하는게 실제 코드가 더 깔끔해 보임.
//        rooms.sort((r1, r2) -> {
//            if (r1.e == r2.e) {
//                return r1.s - r2.s;
//            } else {
//                return r1.e - r2.e;
//            }
//        });

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
