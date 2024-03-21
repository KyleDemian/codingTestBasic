package ColumbusStudy.week1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Question5 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        StringBuilder answer = new StringBuilder();

        if(str == null || str.isEmpty() ||
                str.startsWith("_") || str.endsWith("_") ||
                str.contains("__") ||
                Pattern.compile("[A-Z]").matcher(str.substring(0, 1)).find() ||
                (Pattern.compile("[A-Z]").matcher(str).find() && str.contains("_"))
        ) {
            answer.append("Error!");
        } else {
            // JAVA // C++ 형태인지 구분지어야 함.
            if(str.contains("_")){
                if(str.charAt(0) == '_' || str.charAt(str.length() -1) == '_'){
                    answer.append("Error!");
                }else {
                    String[] arr = str.split("_");
                    for (int i = 0; i < arr.length; i++) {
                        if(arr[i].isEmpty()){
                            answer.append("Error!");
                            break;
                        } else {
                            if(i != 0){
                                answer.append(arr[i].substring(0,1).toUpperCase() + arr[i].substring(1).toLowerCase());
                            } else {
                                answer.append(arr[i].toLowerCase());
                            }
                        }
                    }
                }
            } else if(stringContain(str)) {
                if(Character.isUpperCase(str.charAt(0))){
                    answer.append("Error!");
                } else {
                    for(char x : str.toCharArray()){
                        if(Character.isUpperCase(x)){
                            if(answer.toString().endsWith("_")){
                                answer.append("Error!");
                                break;
                            }
                            answer.append("_").append(Character.toLowerCase(x));
                        }else {
                            answer.append(x);
                        }
                    }
                }
            } else {
                // 소문자만 입력될 경우는 정답 그대로 출력
                answer.append(str);
            }
        }


        System.out.print(answer.toString());
    }

    static boolean stringContain(String s){
        if(s == null || s.isEmpty()){
            return false;
        }

        for (char x : s.toCharArray()){
            if (Character.isUpperCase(x)){
                return true;
            }
        }
        return false;
    }
}
