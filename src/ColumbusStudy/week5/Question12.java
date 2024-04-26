package ColumbusStudy.week5;

import java.util.HashSet;
import java.util.Scanner;

public class Question12 {
    // https://www.acmicpc.net/problem/5568

    private static HashSet<Integer> set = new HashSet<>();
    private static int n, k;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] ch = new boolean[n];
        checked("", ch, 0);

        System.out.println(set.size());
    }

    static void checked(String s, boolean[] ch, int depth) {
        if (depth == k) {
            set.add(Integer.parseInt(s));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                ch[i] = true;
                checked(s + arr[i], ch, depth + 1);
                ch[i] = false;
            }
        }
    }
}
