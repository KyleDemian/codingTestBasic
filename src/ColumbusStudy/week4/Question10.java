package ColumbusStudy.week4;

import java.util.StringTokenizer;

public class Question10 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/92335

    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();

        // n % k는 n의 k진수 표현에서 가장 낮은 자릿수를 구하고,
        // n / k는 가장 낮은 자릿수를 제거.
        // n의 k진수 표현
        while (n > 0) {
            sb.insert(0, n % k);
            n /=k;
        }

        int answer = 0;

        // "0" 을 기준으로 짜름
        StringTokenizer st = new StringTokenizer(sb.toString(), "0");
        while (st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());
            if(isPrime(num)) answer++;
        }

        return answer;
    }

    private boolean isPrime(long n) {
        if(n < 2) return false;
        // 소수 판별시 제곱근으로 하면 속도가 빨라짐
        // num = a*b로 표시 될 수 있고, 반드시 sqrt(num) 이하임.
        // i를 2부터 num까지 증가시키는 대신 2부터 sqrt(num)까지만 증가
        for(long i=2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Question10 T = new Question10();
        System.out.print(T.solution(437674, 3));
        System.out.print(T.solution(110011, 10));
    }
}
