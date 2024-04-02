package day12;

import java.util.*;

public class Question8 {

    // https://www.acmicpc.net/problem/6443
    // 아나그램
    // 틀렸다는데 뭐가 틀린거지.. ? 문제 틀림.. ㅠㅠ

    public static char[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            // 입력이 비어 있거나 공백 문자열 예외처리.
            if (input == null || input.trim().length() == 0) {
                continue;
            }
            arr = input.toCharArray();
            Arrays.sort(arr);
            doAnagram("");
            System.out.println();
        }
        // 해당 글자들로 만들 수 있는 모든 경우의 수 및 구조를 출력
        // 2
        // abc
        // acba

    }

    static void doAnagram(String prefix) {
        if (prefix.length() == arr.length) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!prefix.contains(String.valueOf(arr[i])))
                doAnagram(prefix + arr[i]);
        }
    }
}
