package ColumbusStudy.week10_시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Question7 {
    // https://www.acmicpc.net/problem/1138

    static int N;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        // 줄을 세운 사람들의 왼쪽에 있는 키 큰 사람들의 수를 배열 ch에 저장합니다.
        // 왼쪽에 키 큰 사람들이 많을수록 (예: ch[i] 가 큰 경우), 그 사람은 줄에서 오른쪽에 서야 합니다. 따라서, ch 값이 큰 사람부터 리스트에 넣어줍니다.
        // list.add(ch[i], i+1) 의미: ch[i] 는 왼쪽에 서야 하는 사람 수를 말하며, i+1 은 현재 키 큰 사람의 키입니다. 따라서, ch[i] 왼쪽에 i+1 (키 큰 사람) 이 위치하도록 리스트에 추가하는 것입니다.
        // 내림차순으로 출력하는 부분은 생략하고, 0부터 N까지 오름차순으로 출력하면 그대로 올바른 해답이 출력됩니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        ch = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ch[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = N-1; i >= 0; i--) {
            list.add(ch[i], i+1);
        }

        for (int i = 0; i < N; i++){
            sb.append(list.get(i)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
