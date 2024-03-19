package day9;

import day9.Question6;
import java.util.Scanner;
public class Question6 {
    static int[] unf;

    public static int Find(int v) {
        if(v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa] =fb;
    }

    public static void main(String[] args) {
        Question6 q = new Question6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        for (int i=1; i<= n; i++) unf[i] = i;
        for (int i = 1; i <= m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            Union(a, b);
        }
        int a = kb.nextInt();
        int b = kb.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");

        // 서로서 집합 [친구인지 확인] ( Union & Find )
        // 가장 작은값 Or 가장 큰값을 정해서 시작을 함. offer, poll 넣기, 빼기
        // 9 7  // 첫번째 배열은 총 9 학생수 , 7개 가지수 // 마지막 3 8의 경우 친구인지 묻는것.
        // 1 2
        // 2 3
        // 3 4
        // 1 5
        // 6 7
        // 7 8
        // 8 9
        // 3 8
    }
}
