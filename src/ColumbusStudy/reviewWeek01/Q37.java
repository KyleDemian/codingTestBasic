package ColumbusStudy.reviewWeek01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q37 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Room> r = new ArrayList<Room>();

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);

            r.add(new Room(s, e));
        }

        Collections.sort(r);

        int cnt = 1;
        int finished = finished = r.get(0).e;

        for (int i = 1; i < n; i++) {
            if (r.get(i).s >= finished) {
                finished = r.get(i).e;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static class Room implements Comparable<Room> {
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
}
