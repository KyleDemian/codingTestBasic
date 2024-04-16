package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Question3 {

    // https://cote.inflearn.com/contest/10/problem/04-03

    public ArrayList<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        // 사전 셋팅
        for (int i = 0; i < k - 1; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }

        // 2포인트 알고리즘, 슬라이딩 윈도우 같이 사용함.
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            hm.put(arr[rt], hm.getOrDefault(arr[rt], 0) + 1);
            answer.add(hm.size());
            hm.put(arr[lt], hm.get(arr[lt]) - 1);
            if (hm.get(arr[lt]) == 0) {
                hm.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Question3 T = new Question3();
        Scanner kb = new Scanner(System.in);

        int a = kb.nextInt();
        int b = kb.nextInt();

        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = kb.nextInt();
        }

        // 7 4
        // 20 12 20 10 23 17 10
        for (int x : T.solution(a, b, arr)) {
            System.out.print(x + " ");
        }
    }
}
