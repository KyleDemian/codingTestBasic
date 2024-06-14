package ColumbusStudy.week5_완전탐색_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Question9 {

    // https://www.acmicpc.net/problem/18511
    // 복습 완

    static int N, K;
    static int answer = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr =new int[K];
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        DFS(0);
        System.out.print(answer);
    }

    static void DFS(int now){
        if(now > N) return;
        if(answer < now) answer = now;
        for(int i = K-1; i >= 0 ; i--){
            DFS(now*10+arr[i]);
        }
    }
}

/*
public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        String[] kArr = br.readLine().split(" ");

        int[] k = new int[m];
        for(int i = 0; i < k.length; i++) {
            k[i] = Integer.parseInt(kArr[i]);
        }
        Set<Integer> set = Arrays.stream(k).boxed().collect(Collectors.toSet());

        int val = Integer.MIN_VALUE;

        for (int i = n; i > 0; i--) {
            String a = String.valueOf(i);
            boolean checked = true;

            for (char x : a.toCharArray()) {
                if (!set.contains(Character.getNumericValue(x))) {
                    checked = false;
                    break;
                }
            }

            if (checked) {
                val = i;
                break;
            }
        }

        System.out.println(val);

    }
* */
