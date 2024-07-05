package ColumbusStudy.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Question1 {

    // https://www.acmicpc.net/problem/2729
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");

            BigInteger a = new BigInteger(input[0], 2);
            BigInteger b = new BigInteger(input[1], 2);
            BigInteger sum = a.add(b);

            System.out.println(sum.toString(2));
        }
    }

}
