package day16;

public class Question4 {

    public static void main(String[] args) {
        String[][] plans = {{"aaa", "12:00","20"},{"bbb","12:10","30"},{"ccc","12:40","10"}};
        System.out.println(plans);
    }

    static String[] solution(String[][] plans){


        String[] answer = new String[plans.length];
        return answer;
    }

    public static int getTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[0]);

        return (h * 60) + m;
    }
}
