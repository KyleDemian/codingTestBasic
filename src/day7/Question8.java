package day7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question8 {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (x == e) return answer = L;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }

        return answer;
    }


    public static void main(String[] args) {
        Question8 T = new Question8();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();

        // 상태트리 레벨 탐색 ( 넓이 우선 탐색 : BFS (송아지 탐색) )
        // 앞뒤로, 1씩 움직일 수 있고, 앞으로 최대 5까지 움직일 수 있음
        // 5는 현재 지점, 14는 도착 지점이라고 가정 -> 그럼 1트리당 총 3개의 노드가 생김 +1 -1 +5
        // 5 14
        System.out.println(T.BFS(s,e));
    }
}

class Node8 {
    int data;
    Node8 lt, rt;

    public Node8(int val) {
        data = val;
        lt = rt = null;
    }
}
