package practice3_struct;

import java.util.HashSet;

public class Question1 {
    // 최대 길이 연속수열 - 자료구조의 활용
    public int solution(int[] nums){
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();     // 중복 제거
        for(int x : nums) set.add(x);
        for(int x : set){
            if(set.contains(x - 1)) continue;
            int cnt = 0;
            while(set.contains(x)){
                cnt++;
                x++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Question1 T = new Question1();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
