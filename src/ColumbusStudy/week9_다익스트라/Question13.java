package ColumbusStudy.week9_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question13 {

    // https://www.acmicpc.net/problem/14888

    static int N;
    static int[] number, ch;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // + - * /
        ch = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {
            ch[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0, number[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int L, int sum) {
        if (L == N-1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        } else {
            for (int i = 0; i < 4; i++) {
                if(ch[i] > 0){
                    ch[i]--;
                    if (i == 0) DFS(L+1, sum+number[L+1]);
                    else if (i == 1) DFS(L+1, sum-number[L+1]);
                    else if (i == 2) DFS(L+1, sum*number[L+1]);
                    else DFS(L+1, sum/number[L+1]);
                    ch[i]++;
                }
            }
        }
    }
}
