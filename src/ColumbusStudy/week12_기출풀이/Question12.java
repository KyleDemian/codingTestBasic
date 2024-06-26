package ColumbusStudy.week12_기출풀이;

import java.io.*;
import java.util.*;

public class Question12 {

    // https://www.acmicpc.net/problem/2307
    // 가장 빠른시간이 아니라, 지연시킬수 있는 최대시간..?
    // 그럼 최소값이랑 최대값이랑 빼야하는거같은데 // 그러면 가운데길이 애매해...
    static int N, M;
    static ArrayList<ArrayList<Edge>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(a).add(new Edge(b, cost));
            list.get(b).add(new Edge(a, cost));
        }

        // Calculate minimum distance
        int[] distFromStart = dijkstra(list, 1);
        int originalCost = distFromStart[N];

        if (originalCost == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        // Calculate maximum delay
        int maxDelay = 0;
        for (int i = 1; i <= N; i++) {
            for (Edge edge : new ArrayList<>(list.get(i))) {
                int u = i;
                int v = edge.vex;

                // Create a deep copy of list and sublists
                ArrayList<ArrayList<Edge>> tempList = new ArrayList<>();
                for (ArrayList<Edge> sublist : list) {
                    tempList.add(new ArrayList<>(sublist));
                }
                // Remove edge from copy
                tempList.get(u).removeIf(e -> e.vex == v);
                tempList.get(v).removeIf(e -> e.vex == u);

                // Recalculate with edge removed
                int[] distWithRemovedEdge = dijkstra(tempList, 1);

                int newCost = distWithRemovedEdge[N];
                if (newCost == Integer.MAX_VALUE) {
                    System.out.println(-1);
                    return;
                }
                maxDelay = Math.max(maxDelay, newCost - originalCost);
            }
        }

        System.out.println(maxDelay);
    }

    static int[] dijkstra(ArrayList<ArrayList<Edge>> list, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int v = cur.vex;
            int nowCost = cur.cost;

            if (nowCost > dist[v]) continue;

            for (Edge ob : list.get(v)) {
                int next = ob.vex;
                int addCost = nowCost + ob.cost;
                if (dist[next] > addCost) {
                    dist[next] = addCost;
                    pq.offer(new Edge(next, addCost));
                }
            }
        }

        return dist;
    }

    static class Edge implements Comparable<Edge> {
        int vex, cost;

        public Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge ob) {
            return this.cost - ob.cost;
        }
    }
}
