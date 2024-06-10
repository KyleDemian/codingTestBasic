package ColumbusStudy.week10_시뮬레이션;

import java.io.*;
import java.util.*;

public class Question8 {

    // https://www.acmicpc.net/problem/17140
    // R 연산: 배열 A의 모든 행에 대해서 정렬을 수행, 행의 개수 ≥ 열의 개수인 경우에 적용
    // C 연산: 배열 A의 모든 열에 대해서 정렬을 수행, 행의 개수 < 열의 개수인 경우에 적용
    // 공백을 0으로 채움
    static int r, c, k;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[101][101];

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 행렬값 및 고정값 -> 그 수만큼 채워야됌.
        int row = 3, col = 3;
        for (int t = 0; t <= 100; t++) {
            if(A[r][c] == k){
                System.out.println(t);
                return;
            }

            // R 연산
            if(row >= col){
                int nRow = 0;
                for (int i = 1; i <= row; i++) {
                    int[] count = new int[101];
                    for (int j = 1; j <= col; j++) {
                        count[A[i][j]]++;
                        A[i][j] = 0;
                    }

                    ArrayList<Pair> pairs = new ArrayList<>();
                    for (int j = 1; j <= 100; j++) {
                        if(count[j] > 0) pairs.add(new Pair(j, count[j]));
                    }

                    Collections.sort(pairs);

                    int idx = 1;
                    for(Pair ob : pairs){
                        A[i][idx++] = ob.num;
                        A[i][idx++] = ob.cnt;
                        if(idx > 100) break;
                    }
                    nRow = Math.max(nRow, idx - 1);
                }
                col = nRow;
            } else {
                int nCol = 0;
                for (int j = 1; j <= col; j++) {
                    int[] count = new int[101];
                    for (int i = 1; i <= row; i++) {
                        count[A[i][j]]++;
                        A[i][j] = 0;
                    }

                    ArrayList<Pair> pairs = new ArrayList<>();
                    for (int i = 1; i <= 100; i++) {
                        if (count[i] > 0) pairs.add(new Pair(i, count[i]));
                    }

                    Collections.sort(pairs);

                    int idx = 1;
                    for (Pair ob : pairs) {
                        A[idx++][j] = ob.num;
                        A[idx++][j] = ob.cnt;
                        if (idx > 100) break;
                    }
                    nCol = Math.max(nCol, idx - 1);
                }
                row = nCol;
            }
        }

        System.out.println(-1);
    }

    static class Pair implements Comparable<Pair>{
        int num, cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o){
            if(this.cnt == o.cnt) return this.num - o.num;
            else return this.cnt - o.cnt;
        }
    }
}
