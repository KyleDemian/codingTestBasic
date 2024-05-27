package ColumbusStudy.week1_문자열;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Question5 {

    // https://www.acmicpc.net/problem/3613
    // 그럼 사실 소문자도 Error! 나와야하는데 이건 또 그냥 출력해야함... 문제 제대로 이해하고작성한거 맞나?
    // 입력으로 주어진 변수명이 Java형식이면, C++형식으로 출력하고, C++형식이라면 Java형식으로 출력한다.
    // 둘 다 아니라면 "Error!"를 출력한다.
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        StringBuilder sb = new StringBuilder();

        if(str == null || str.isEmpty() ||
                str.startsWith("_") || str.endsWith("_") ||
                str.contains("__") ||
                Pattern.compile("[A-Z]").matcher(str.substring(0, 1)).find() ||
                (Pattern.compile("[A-Z]").matcher(str).find() && str.contains("_"))
        ) {
            sb.append("Error!");
        } else {
            // JAVA // C++ 형태인지 구분지어야 함.
            if(str.contains("_")){
                String[] arr = str.split("_");
                for (int i = 0; i < arr.length; i++) {
                    if(i != 0){
                        sb.append(arr[i].substring(0,1).toUpperCase() + arr[i].substring(1).toLowerCase());
                    } else {
                        sb.append(arr[i].toLowerCase());
                    }
                }
            } else if(stringContain(str)) {
                for(char x : str.toCharArray()){
                    if(Character.isUpperCase(x)){
                        sb.append("_").append(Character.toLowerCase(x));
                    }else {
                        sb.append(x);
                    }
                }
            } else {
                // 소문자만 입력될 경우는 정답 그대로 출력
                sb.append(str);
            }
        }
        System.out.print(sb.toString());
    }

    static boolean stringContain(String s){
        for (char x : s.toCharArray()){
            if (Character.isUpperCase(x)){
                return true;
            }
        }
        return false;
    }
}
