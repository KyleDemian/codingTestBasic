package day13;

import java.time.LocalTime;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();
        int tt = sc.nextInt();

        LocalTime time = LocalTime.of(H, M).plusMinutes(tt);

        System.out.println(time.getHour() + " " + time.getMinute());
    }
}
