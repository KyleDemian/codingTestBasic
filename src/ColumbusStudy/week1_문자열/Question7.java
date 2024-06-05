package ColumbusStudy.week1_문자열;

import java.util.Scanner;

public class Question7 {

    // https://www.acmicpc.net/problem/1929
    // 복습 완

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt();
        int n = kb.nextInt();
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[n+1];

        // 스트링 빌더  \\n 넣어서 한번에 출력해볼것.
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                // 배열값에서 배수들 전부 True 변경
                for (int j = i; j <= n; j += i) {
                    arr[j] = true;
                }
                // 소수값 출력
                if (i >= m) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }

    /*  시간 최적화 된 코드 // O(n log log n)
    // 제곱근의 값은 수학적 사실 -> 숫자 5가 판별을 할때
    // 다른 수로 나눠지지 않는 수 // 1 * n // n^2
    // 두수가 곱한 값을 가지고왔을때 // 제곱근까지만 확인 하면 됌.
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt();
        int n = kb.nextInt();
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;

        i의 배수를 체크하는 것은 i의 제곱 부터 시작하면 됩니다. 왜냐하면 i의 제곱 미만의 수는 이전의 숫자들의 곱으로 나타낼 수 있기 때문입니다.
        for (int i = 2; i * i <= n; i++) {
            if (arr[i]) {
                루프는 sqrt(n)까지만 수행해도 충분합니다. 왜냐하면 sqrt(n) 이상의 숫자들은 n 이하의 소수를 가질 수 없기 때문입니다
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = false;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }
    * */
}
