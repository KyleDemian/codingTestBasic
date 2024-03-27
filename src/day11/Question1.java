package day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) throws IOException {
        Question1 q = new Question1();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(q.solution(arr, n));
    }

    public int solution(int[] box, int n) {
        int answer = (box[0]/n) * (box[1]/n) * (box[2]/n);
        return answer;
    }
}
