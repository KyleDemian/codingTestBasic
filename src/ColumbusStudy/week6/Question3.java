package ColumbusStudy.week6;

import java.util.Scanner;

public class Question3 {
    // https://www.acmicpc.net/problem/6603

    static int k;
    static int[] arr, result;
    static boolean[] ch;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        while(true){
            k = kb.nextInt();
            if(k == 0) break;

            arr = new int[k];
            result = new int[6];
            ch = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = kb.nextInt();
            }

            DFS(0, 0);
            sb.append("\n");
            System.out.print(sb.toString());
            sb.setLength(0);
        }
    }

    static void DFS(int start, int depth) {
        if (depth == 6) {
            for (int x : result) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 방문했던 요소를 다시 방문하지 않기 위해서 start 값으로 설정.
        for(int i = start; i < k; i++) {
            if (!ch[i]) {
                ch[i] = true;
                result[depth] = arr[i];
                DFS(i, depth + 1);
                ch[i] = false;
            }
        }
    }
}
