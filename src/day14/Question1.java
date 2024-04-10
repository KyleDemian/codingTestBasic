package day14;

public class Question1 {

    public static void main(String[] args) {
        Question1 q = new Question1();
        int[] food = {0, 3, 7, 3};
        q.solution(food);
    }

    public String solution(int[] food) {
        String answer = "";

        String result = "";
        String reverseResult = "";
        for(int i = 1; i < food.length; i++){
            int a = food[i] / 2;

            for(int j = 1; j <= a ; j++){
                result += i + "";
            }
        }

        for(int i = result.length() -1; i >=0 ; i--){
            reverseResult += result.charAt(i);
        }

        answer = result + "0" + reverseResult;


        return answer;
    }
}
