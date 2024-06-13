package ColumbusStudy.week3_자료구조_투포인트;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question2 {

    // https://www.acmicpc.net/problem/2870
    // 복습 완 // BigInteger , regex.Pattern, regex.Matcher
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] arr = new String[n];
        kb.nextLine();

        // 숫자값만 매칭하는 부분 필요. \\d 숫자 + 모든
        Pattern pa = Pattern.compile("\\d+");

        // 숫자 값 편하게 정렬하기 위해서 만듦
        List<BigInteger> list = new ArrayList<>();

        // 들어온 문자 완료
        for (int i = 0; i < n; i++) {
            arr[i] = kb.next();
            Matcher ma = pa.matcher(arr[i]);
            while (ma.find()) {
                list.add(new BigInteger(ma.group()));
//                list.add(Integer.parseInt(ma.group()));
            }
        }

        // 타입	        범위	                                                메모리 크기 (64bit 기준)	기본/참조형	    저장된 위치
        // int	        -2,147,483,648 ~ 2,147,483,647	                        4 Byte	                    기본형	        Stack
        // long	        -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807	8 Byte	                    기본형	        Stack
        // BigInteger	무한 (Infinity)	                                        Minimum 70 Byte	            참조형	        Heap

        // 오름차순
        Collections.sort(list);
        list.forEach(a -> System.out.println(a));
    }
}
