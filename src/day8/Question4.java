package day8;

import java.util.Scanner;

public class Question4 {

    static int[] pm;
    static int n, m;
    public void DFS(int l) {
        if (l == m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        } else{
            for (int i = 1; i <= n; i++) {
                pm[l] = i;
                DFS(l+1);
            }
        }
    }

    public static void main(String[] args) {
        Question4 q = new Question4();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[m];
        q.DFS(0);
        // 중복순열 구하기 - 해당 부분은 여러가지의 갈래가 뻣음.
        // 3 2
    }
}
