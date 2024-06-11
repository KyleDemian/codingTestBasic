package ColumbusStudy.week11_기출풀이;

import java.io.*;
import java.util.*;

public class Question2 {

    // https://www.acmicpc.net/problem/1759
    // 복습 완
    static int L, C;
    static char[] arr;
    static int[] ch;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());   // 길이
        C = Integer.parseInt(st.nextToken());   // 조합의 알파벳 종류

        arr = new char[C];
        ch = new int[C];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        backTracking(0,0,0);

        System.out.print(sb);
    }

    static void backTracking(int v, int cnt, int dd){
        if (cnt == L) {
            // 자음의 개수가 2개 이상이면서,모음이 1개라도 포함된 것,
            if(dd >= 2 && L - dd >= 1){
                for (int i = 0; i < C; i++) {
                    if(ch[i] == 1) sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        } else {
            for (int i = v; i < C; i++) {
                ch[i] = 1;
                if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                    backTracking(i + 1, cnt + 1, dd);
                } else {
                    backTracking(i+1, cnt+1, dd+1);
                }
                ch[i] = 0;
            }
        }
    }
}