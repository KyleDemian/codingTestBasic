package ColumbusStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question6 {
    // https://www.acmicpc.net/problem/20300

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        long[] arr = Arrays.stream(str).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);

        long max = 0;
        if (n % 2 != 0) {
            max = arr[n - 1];
            n -= 1;
        }

        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, arr[i] + arr[n - 1 - i]);
        }

        System.out.println(max);
    }
}


/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");

        long[] arr = Arrays.stream(str).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);

        long lt = 0, rt = 0;
        long min = 0;
        while (lt <= rt) {
            lt = arr[0];
            if(n%2 == 0){ rt = arr[n-1]; }
            else { min = arr[n-1]; break; }

            min = lt + rt;
            break;
        }

        System.out.println(min);
    }
* */