package practice2_hashing;

import java.util.HashMap;

public class Question1 {

    public int solution(String s){
        int answer = -1;
        HashMap<Character, Integer> hs = new HashMap<>();
        for (char x : s.toCharArray()) {
            hs.put(x, hs.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if(hs.get(s.charAt(i)) == 1) {  // 첫 번째로 등장하는 문자를 찾았다면
                answer = i + 1;  // answer를 현재 인덱스로 설정하고,
                break;  // 루프를 멈춥니다.
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Question1 T = new Question1();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
