package ColumbusStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question1 {

    // https://www.acmicpc.net/problem/10870
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 오답 이유, n 값이 0 또는 1, 2 일때의 경우를 생각하지 않았음.
        // 기존에는 1 1 값을 가지고 시작햇지만, 여기서의 차수는 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 .....
        // 문제에 대해서 오류가 있는거 같음 0 부터시작하면 값이 34가 10번째 항이고,
        // 1부터 시작하면 55가 10번째 항임. 그래서 문제가 틀린것으로 보임.

//        int a = 1, b = 1, c = 0;
//        if (n == 0) {
//            System.out.println(0);
//        } else if (n == 1 || n == 2) {
//            System.out.println(1);
//        } else {
//            for (int i = 2; i < n; i++) {
//                c = a + b;
//                a = b;
//                b = c;
//            }
//            System.out.println(c);
//        }

        int result = fibo(n);
        System.out.println(result);
    }

    static int fibo(int n){
        if(n <= 0) return 0;
        else if(n == 1 )  return 1;
        else return fibo(n-1) + fibo(n-2);
    }
}
