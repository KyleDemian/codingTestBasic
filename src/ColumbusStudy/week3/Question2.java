package ColumbusStudy.week3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question2 {

    // https://www.acmicpc.net/problem/2870
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] arr = new String[n];
        kb.nextLine();

        // 숫자값만 매칭하는 부분 필요.
        Pattern pa = Pattern.compile("\\d+");

        // 숫자 값 편하게 정렬하기 위해서 만듦
        List<BigInteger> list = new ArrayList<>();

        // 들어온 문자 완료
        for (int i = 0; i < n; i++) {
            arr[i] = kb.next();
            Matcher ma = pa.matcher(arr[i]);
            while (ma.find()) {
                list.add(new BigInteger(ma.group()));
            }
        }

        // 오름차순
        Collections.sort(list);
        list.forEach(a -> System.out.println(a));
    }
}
