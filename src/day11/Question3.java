package day11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) throws IOException {
        Question3 q = new Question3();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        kb.nextLine();
        String str = kb.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(q.solution(arr, str));
    }

    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int temp;

        if(direction.equals("right")) {
            temp = numbers[numbers.length - 1];
            for(int i = numbers.length - 1; i > 0 ; i--){
                answer[i] = numbers[i - 1];
            }
            answer[0] = temp;
        }
        else {
            temp = numbers[0];
            for(int i = 0; i < numbers.length - 1; i++){
                answer[i] = numbers[i + 1];
            }
            answer[numbers.length - 1] = temp;
        }

        return answer;
    }
}
