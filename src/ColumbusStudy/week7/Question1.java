package ColumbusStudy.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1 {

    // https://www.acmicpc.net/problem/17478

    static String s1, s2, s3, s4 ;
    static String end, space;
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");

        s1 = "\"재귀함수가 뭔가요?\"\n";
        s2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        s3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
        s4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";

        end = "라고 답변하였지.\n";

        space = "____";

        int cnt = 0;
        recursion(0);

        System.out.println(sb.toString());
    }

    static void recursion(int cnt) {
        if (n == cnt) {
            sb.append(space.repeat(cnt)).append(s1);
            sb.append(space.repeat(cnt)).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            for (int i = cnt; i >= 0; i--) {
                sb.append(space.repeat(i)).append(end);
            }
            return;}
        sb.append(space.repeat(cnt)).append(s1);
        sb.append(space.repeat(cnt)).append(s2);
        sb.append(space.repeat(cnt)).append(s3);
        sb.append(space.repeat(cnt)).append(s4);
        recursion(++cnt);
    }
}
