package day15;

import java.util.ArrayList;

public class Question5 {

    // 바이토닉 수열, 수열이 증가했다가 감소하는 수열

    public int solution(int[] nums){
        int answer = 0;
        int n = nums.length;
        ArrayList<Integer> peaks = new ArrayList<>();
        // 봉우리 값을 찾음.
        for(int i = 1; i < n-1; i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                peaks.add(i);
            }
        }

        // 봉우리 지점 찾음.
        for(int x : peaks){
            int left = x;
            int right = x;
            int cnt = 1;
            while(left-1 >= 0 && nums[left-1] < nums[left]){
                left--;
                cnt++;
            }
            while(right+1 < n && nums[right] > nums[right+1]){
                right++;
                cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Question5 T = new Question5();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
