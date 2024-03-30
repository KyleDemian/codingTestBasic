package ColumbusStudy.week2;

import java.util.Scanner;

public class Question8 {

    // https://www.acmicpc.net/problem/2840
    // 도대체 뭐라는거야?
    // 돌림판 화살표 n 개의 칸 K 번 돌림

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();

        // 알파벳 넣기
        char[] arr = new char[26];


        for (int i = 0; i < n; i++) {
            arr[i] = (char) ('A' + i);
        }
    }
}


