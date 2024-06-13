package ColumbusStudy.week3_자료구조_투포인트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question5 {

    // https://www.acmicpc.net/problem/1620
    // 복습 완
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> pName = new HashMap<>();
        HashMap<Integer, String> pNumber = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String a = br.readLine();
            pName.put(a, i);
            pNumber.put(i, a);
        }

        for(int i = 0; i < M ; i++) {
            String a = br.readLine();
            if(a.matches("\\d+")) {
                sb.append(pNumber.get(Integer.parseInt(a))).append("\n");
            } else {
                sb.append(pName.get(a)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
