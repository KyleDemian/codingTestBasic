package ColumbusStudy.week1;

import java.util.Scanner;

public class Question7 {

    // 에라토스테네스의 체 방식으로 풀어야함..
    // 뭔지는 정확하게 아는데, 배열에다가 담아서 그 배열값에서 미래의 될것들을 다 체크해서 다 삭제 ( 배열 Boolean Or 숫자값으로 )
    // 입력받는값의 이상이면서 이하인값 // m 의 최소값은 그러면 2 이상임
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int m = kb.nextInt();
        int n = kb.nextInt();
        boolean[] arr = new boolean[n+1];

        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                // 배열값에서 배수들 전부 True 변경
                for (int j = i; j <= n; j += i) {
                    arr[j] = true;
                }
                // 소수값 출력
                if (i >= m) {
                    System.out.println(i);
                }
            }
        }
    }

    /*  시간 최적화 된 코드 // O(n log log n)
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
