package day8;

import java.util.Scanner;

public class Question8 {    // 하나도 이해가 안되네 수열은;;
    static int[] b, p, ch;
    static  int n, f;
    boolean flag = false;
    // 메모이제이션
    int[][] dy = new int[35][35];

    public int combi(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if(n == r || r==0) return 1;
        else return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
    public void DFS(int l, int sum) {
        if(flag) return;
        if (l == n) {
            if(sum == f){
                for (int x : p) {
                    System.out.print(x + " ");
                    flag= true;
                }
            }
        } else{
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i]= 1;
                    p[l]= i;
                    DFS(l+1, sum+(p[l]*b[l]));
                    ch[i]= 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question8 q = new Question8();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        b = new int[n];
        p = new int[n];
        ch= new int[n+1];   // 1부터 시작하기때문에,
        for (int i = 0; i < n; i++) {
            b[i] = q.combi(n - 1, i);
        }
        q.DFS(0, 0);
        // 수열 추측하기 -> 역삼각형 아래 값부터 위의 값 추측
        // 4 16
        // 3 1 2 4
    }
}
