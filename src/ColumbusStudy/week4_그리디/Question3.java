package ColumbusStudy.week4_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question3 {

    // https://www.acmicpc.net/problem/1343
    // 복습 완

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().replace("XXXX", "AAAA").replace("XX","BB");

        if(str.contains("X")) System.out.print("-1");
        else System.out.print(str);
    }
}

