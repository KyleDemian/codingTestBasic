package ColumbusStudy.week8_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Question11 {
    // https://www.acmicpc.net/problem/2668

    static int[] arr, ch;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        ch = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n; i++) {
            ch[i] = 1;
            DFS(i, i);
            ch[i] = 0;
        }

        Collections.sort(list);
        System.out.println(list.size());
        list.stream().forEach(System.out::println);
    }

    static void DFS(int idx, int x) {
        if(ch[arr[idx]] == 0){
            ch[arr[idx]] = 1;
            DFS(arr[idx], x);
            ch[arr[idx]] = 0;
        }
        if(arr[idx] == x) list.add(x);
    }
}
