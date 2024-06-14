package ColumbusStudy.week4_그리디;

import java.util.*;
import java.io.*;

public class Question2 {

    // https://www.acmicpc.net/problem/1758
    // 복습 완
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long answer = 0;
        for(int i = n-1, j = 0; i >=0; i--, j++){
            int tip = arr[i] - j;
            if(tip > 0 ) answer += tip;
        }

        System.out.print(answer);
    }
}
