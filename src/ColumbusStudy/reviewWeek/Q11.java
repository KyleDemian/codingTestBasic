package ColumbusStudy.reviewWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Stack<Double> stack = new Stack<>();
        double[] arr = new double[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double answer = 0;
        double lt = 0.0, rt = 0.0;


        for (char x : str.toCharArray()) {
            if (Character.isAlphabetic(x)) {
                int idx = x - 'A';
                // arr[i] 의 인덱스값임. A - 0, B - 1 .....
                stack.push(arr[idx]);
            } else {
                rt = stack.pop();
                lt = stack.pop();
                switch(x){
                    case '+':
                        stack.push(lt + rt);
                    break;
                    case '-':
                        stack.push(lt - rt);
                    break;
                    case '*':
                        stack.push(lt * rt);
                    break;
                    case '/':
                        stack.push(lt / rt);
                    break;
                }
            }
        }
        answer = stack.peek();
        System.out.printf("%.2f", answer);
    }
}
