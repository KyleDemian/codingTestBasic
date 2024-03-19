package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge8 implements Comparable<Edge8> {
    public int vex;
    public int cost;

    public Edge8(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge8 o) {
        return this.cost - o.cost;
    }
}
public class Question8 {
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
        Question8 q = new Question8();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n + 1];
        ArrayList<ArrayList<Edge8>> graph = new ArrayList<>();
        for (int i = 0; i <= n ; i++) {
            graph.add(new ArrayList<Edge8>());
        }
        int[] ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            // 무방향 인접리스트때문에 ( -> <- )
            graph.get(a).add(new Edge8(b, c));
            graph.get(b).add(new Edge8(a, c));
        }
        int answer = 0;
        PriorityQueue<Edge8> pq = new PriorityQueue<>();
        pq.offer(new Edge8(1, 0));

        while (!pq.isEmpty()) {
            Edge8 tmp = pq.poll();
            int ev = tmp.vex;
            if (ch[ev] == 0) { // 회로가 되는것을 방지하기 위함.
                ch[ev]=1;
                answer+= tmp.cost;
                for (Edge8 ob : graph.get(ev)) {
                    if(ch[ob.vex] == 0) pq.offer(new Edge8(ob.vex, ob.cost));
                }
            }
        }

        System.out.println(answer);

        // 원더랜드 ( 최소스패닝트리 : 프림 : priorityQueue 사용)
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
