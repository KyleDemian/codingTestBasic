package ColumbusStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question5 {
    // https://www.acmicpc.net/problem/13305

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 수 , 도시간 키로수, point -  도시별 용량
        int n = Integer.parseInt(br.readLine());
        String[] kmS = br.readLine().split(" ");
        String[] pointS = br.readLine().split(" ");

        // 숫자형태의 배열로 변경
        // 사실... 스트림이 비용이 쌔서 써도 될지는 모르겠음..
        int[] km = Arrays.stream(kmS).mapToInt(Integer::parseInt).toArray();
        int[] point = Arrays.stream(pointS).mapToInt(Integer::parseInt).toArray();

        long sum = 0 ;
        long minCost = point[0];

        for (int i = 0; i < n - 1; i++) {
            if (point[i] < minCost) {
                minCost = point[i];
            }
            sum += km[i] * minCost;
        }

        System.out.print(sum);
    }
}
