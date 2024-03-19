package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge7 implements Comparable<Edge7> {
    public int v1;
    public int v2;
    public int cost;

    public Edge7(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge7 o) {
        return this.cost - o.cost;
    }
}
public class Question7 {
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
        Question7 q = new Question7();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        ArrayList<Edge7> arr = new ArrayList<>();

        for (int i=1; i<= n; i++) unf[i] = i;   // 1 로 초기화

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Edge7(a, b, c));
        }
        int answer = 0;
        Collections.sort(arr);
        for (Edge7 ob : arr) {
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);
            if (fv1 != fv2) {
                answer += ob.cost;
                Union(ob.v1, ob.v2);
            }
        }

        System.out.println(answer);

        // 원더랜드 ( 최소스패닝트리 : 크루스칼 : Union & Find )
        // 가장 작은값 Or 가장 큰값을 정해서 시작을 함. offer, poll 넣기, 빼기
        // 9 12
        // 1 2 12
        // 1 9 25
        // 2 3 10
        // 2 8 17
        // 2 9 8
        // 3 4 18
        // 3 7 55
        // 4 5 44
        // 5 6 60
        // 5 7 38
        // 7 8 35
        // 8 9 15
    }
}
