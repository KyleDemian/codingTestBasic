package ColumbusStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question3 {

    // https://www.acmicpc.net/problem/1343
    // 폴리오미노
    // -> 크기가 전부 동일한 정사각형을 여러 개 이어붙여서 만든 도형이다. 이어붙인 개수에 따라 이름이 결정된다
    // 해당 문제는 단순 치환 문제임...
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = str.replace("XXXX", "AAAA").replace("XX", "BB");

        if (str.contains("X")) {
            System.out.print("-1");
        } else {
            System.out.print(str);
        }

    }
}
