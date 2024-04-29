package ColumbusStudy.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Question2 {
    // https://www.acmicpc.net/problem/1325
    // https://smartpro.tistory.com/23 참고
    // 암튼 다 틀렸음.. 포기... 패스 -_-..

    public static ArrayList<ArrayList<Integer>> list;
    public static int[] result;
    public static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cntComp = Integer.parseInt(st.nextToken());
        int cntTrust = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= cntComp; i++) {
            list.add(new ArrayList<>());
        }

        result = new int[cntComp + 1];

        for (int i = 0; i < cntTrust; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(B).add(A);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int max = -1;

        for (int i = 1; i <= cntComp; i++) {
            check = new boolean[cntComp + 1];
            dfs(i);
        }

        for (int i = 1; i <= cntComp; i++) {
            if (result[i] > max) {
                max = result[i];
                answer = new ArrayList<>();
                answer.add(i);
            } else if (result[i] == max) {
                answer.add(i);
            }
        }

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    public static void dfs(int v) {
        check[v] = true;

        for (int i : list.get(v)) {
            if (!check[i]) {
                result[i]++;
                dfs(i);
            }
        }
    }
}
