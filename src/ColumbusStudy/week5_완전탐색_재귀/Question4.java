package ColumbusStudy.week5_완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Question4 {

    // https://www.acmicpc.net/problem/2798
    // 복습 완
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < N; i++){
            for(int j= i+1; j < N; j++){
                for(int l = j+1; l< N; l++){
                    int val = arr[i] + arr[j] + arr[l];
                    if(val <= M && val > sum){
                        sum = val;
                    }
                }
            }
        }
        System.out.print(sum);
    }
}


/*

public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        String[] numbers = br.readLine().split(" ");

        int val = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int value = Integer.parseInt(numbers[i]) + Integer.parseInt(numbers[j]) + Integer.parseInt(numbers[k]);
                    // 틀린 이유 조건을 한개만 설정 3개의 합이 현재 등록된 값보다 커야만 함이라는 조건이 빠져있어서 오류임
                    // 이렇게 해야 값이 추가적으로 변경되지 않음.
                    if (value <= m && value > val) {
                        val = value;
                    }
                }
            }
        }

        System.out.println(val);
    }

 */