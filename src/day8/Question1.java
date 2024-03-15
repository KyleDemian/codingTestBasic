package day8;

import java.util.Scanner;

public class Question1 {

    static String answer = "NO";
    static int n, total = 0;
    boolean flag = false;

    public void DFS(int l, int sum,int[] arr) {
        if(flag) return;
        if(sum > total/2) return;

        if (l == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(l + 1, sum + arr[l], arr);
            DFS(l + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Question1 q = new Question1();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            total += arr[i];
        }

        q.DFS(0, 0, arr);
        System.out.println(answer);
        // 합이 같은 부분 집합 (DFS : 아마존 인터뷰 )
        // 6
        // 1 3 5 6 7 10
    }
}
