package ColumbusStudy.week9_다익스트라;

import java.util.*;
import java.io.*;

public class Question2 {
    // https://www.acmicpc.net/problem/17396

    static int n, m;
    static boolean[] sight;
    static ArrayList<Node>[] list;
    static long[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sight = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int flag = Integer.parseInt(st.nextToken());
            if(flag == 1) sight[i] = true;
            else sight[i] = false;
        }

        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, c));
            list[e].add(new Node(s, c));
        }
        //입력 끝

        dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        dijkstra();

        if(dist[n - 1] == Long.MAX_VALUE) System.out.println("-1");
        else System.out.println(dist[n - 1]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        q.offer(new Node(0, 0));

        while(!q.isEmpty()) {
            Node current = q.poll();

            if(visited[current.node]) continue;
            visited[current.node] = true;

            for(int i = 0; i < list[current.node].size(); i++) {
                Node next = list[current.node].get(i);
                if(next.node != n - 1 && sight[next.node]) continue;
                if(dist[next.node] > dist[current.node] + next.cost) {
                    dist[next.node] = dist[current.node] + next.cost;
                    q.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int node;
        long cost;

        public Node(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return (int) (this.cost - n.cost);
        }
    }
}
