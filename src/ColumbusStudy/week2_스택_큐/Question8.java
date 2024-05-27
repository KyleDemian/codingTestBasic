package ColumbusStudy.week2_스택_큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question8 {

    // https://www.acmicpc.net/problem/2840
    // 도대체 뭐라는거야? > 아예 손도 대지 못했음
    // 돌림판 화살표 n 개의 칸 K 번 돌림

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char[][] possible_letters = new char[n][26];
        List<Integer> positions = new ArrayList<>();
        positions.add(0);

        for (int i = 0; i < k; i++) {
            int l = sc.nextInt();
            char c = sc.next().charAt(0);

            List<Integer> new_positions = new ArrayList<>();
            for (Integer pos : positions) {
                int new_pos = (pos + l) % n;
                if (possible_letters[new_pos][c - 'A'] != c && possible_letters[new_pos][c - 'A'] != 0) {
                    continue;
                }
                possible_letters[new_pos][c - 'A'] = c;
                new_positions.add(new_pos);
            }

            positions = new_positions;

            for (char[] letters : possible_letters) {
                if (letters[c - 'A'] != 0 && letters[c - 'A'] != c) {
                    System.out.println("!");
                    return;
                }
            }
        }

        for (char[] letters : possible_letters) {
            boolean found = false;
            for (char letter : letters) {
                if (letter != 0) {
                    System.out.print(letter);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.print('?');
            }
        }
    }
}


