package ColumbusStudy.week12_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question2 {

    // https://www.acmicpc.net/problem/21941
    // https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-21941%EC%9E%90%EB%B0%94-java-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%A0%9C%EA%B1%B0
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int n = S.length();
        int[] dp = new int[n + 1];
        int m = Integer.parseInt(br.readLine());

        String[] arrString = new String[m];
        int[] arrInt = new int[m];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrString[i] = st.nextToken();
            arrInt[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            for (int j = 0; j < m; j++) {
                if (S.startsWith(arrString[j], i)) {
                    int k = i + arrString[j].length();
                    dp[i] = Math.max(dp[i], dp[k] + arrInt[j]);
                }
            }
        }

        System.out.println(dp[0]);
    }

    static int[] getNext(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                next[i] = ++j;
            }
        }
        return next;
    }

    static List<Integer> kmp(String s, String pattern) {
        List<Integer> ret = new ArrayList<>();
        int[] next = getNext(pattern);
        int matched = 0;
        for (int i = 0; i < s.length(); i++) {
            while (matched > 0 && s.charAt(i) != pattern.charAt(matched)) {
                matched = next[matched - 1];
            }
            if (s.charAt(i) == pattern.charAt(matched)) {
                if (matched == pattern.length() - 1) {
                    ret.add(i - matched);
                    matched = next[matched];
                } else {
                    matched++;
                }
            }
        }
        return ret;
    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String S = br.readLine();
//        int M = Integer.parseInt(br.readLine());
//
//        String[] arrString = new String[M];
//        int[] arrInt = new int[M];
//
//        for (int i = 0; i < M; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            arrString[i] = st.nextToken();
//            arrInt[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int total = 0;
//        while(true){
//            boolean flag = false;
//
//            for (int i = 0; i < M; i++) {
//                String before = S;
//                S = S.replaceFirst(arrString[i], "");
//
//                if(!before.equals(S)){
//                    total += arrInt[i];
//                    flag = true;
//                    break;
//                }
//            }
//
//            if(!flag) break;
//        }
//
//        total += S.length();
//
//        System.out.println(total);
//    }
}
