package ColumbusStudy.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Question1 {

    // https://www.acmicpc.net/problem/1059
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        int[] arr= new int[S];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        Question1 q = new Question1();
        System.out.print(q.solution(S, arr, n));
    }

    static int solution(int s, int[] arr, int n) {
        // 정렬
        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        if(arr[0] > n) end = arr[0];
        else {
            for (int i = 0; i < s-1; i++) {
                if(arr[i] == n || arr[i+1] == n){
                    return 0;
                }
                if(arr[i] < n && arr[i+1] >n){
                    start = arr[i];
                    end = arr[i+1];
                }
            }
        }
        int answer = (n-start-1)+(end-n-1) + (n-start-1)*(end-n-1);

        return answer;
    }
}
