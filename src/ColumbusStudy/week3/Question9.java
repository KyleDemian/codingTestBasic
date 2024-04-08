package ColumbusStudy.week3;

import java.util.Arrays;
import java.util.Scanner;

public class Question9 {

    // https://www.acmicpc.net/problem/1940
    // 완전탐색..!? 확인해볼것

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();   // 재료 수
        int m = kb.nextInt();   // 갑옷을 만드는데 필요한 수
        kb.nextLine();
        String[] str = kb.nextLine().split(" ");    // n 재료들이 가진 고유한 번호들
        int[] numbers = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            numbers[i] = Integer.parseInt(str[i]);
        }

        // 2포인트 알고리즘은 정렬 이후 사용해야 함. ( 기준 )
        Arrays.sort(numbers);

        int result = 0;
        int lt = 0, rt = numbers.length - 1;
        // 갑옷은 2개의 재료로 만들고, 두 재료의 고유한 번호를 합쳐서 M 이되면 갑옷 생성
        while(lt < rt){
            int sum = numbers[lt] + numbers[rt];
            if (sum == m) {
                result++;
                lt++;
                rt--;
            } else if (sum < m) {
                lt++;
            } else if (sum > m) {
                rt--;
            }
        }
        System.out.println(result);
    }
}


/*
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();   // 재료 수
        int m = kb.nextInt();   // 갑옷을 만드는데 필요한 수
        kb.nextLine();
        String[] str = kb.nextLine().split(" ");    // n 재료들이 가진 고유한 번호들
        int result = 0;
        // 갑옷은 2개의 재료로 만들고, 두 재료의 고유한 번호를 합쳐서 M 이되면 갑옷 생성
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int a = Integer.parseInt(str[i]);
                int b = Integer.parseInt(str[j]);
                if ((a + b) == m) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
* */