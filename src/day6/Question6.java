package day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question6 {

    // https://cote.inflearn.com/contest/10/problem/06-06

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for (int i = 0; i < n; i++) {
            if (arr[i] != tmp[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Question6 T = new Question6();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        // 반 학생들의 키가 가장 작은 학생부터 1열로 세움, 근데 철수놈이 짝꿍과 순서를 바꿈 -> 철수 번호와, 짝꿍의 번호를 출력
        // 9
        // 120 125 152 130 135 135 143 127 160
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
