package ColumbusStudy.week12_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question7 {

    // https://www.acmicpc.net/problem/1929
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] ch = new boolean[N+1];

        for (int i = 2; i <= N; i++) {
            if(!ch[i]) {
                for(int j = i; j <= N; j = j+i){
                    ch[j] = true;
                }
                if (i >= M) {
                    sb.append(i).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
