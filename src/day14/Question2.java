package day14;

import java.time.LocalDate;

public class Question2 {

    public static void main(String[] args) {
        Question2 q = new Question2();
        q.solution(2, 5);
    }

    public String solution(int a, int b) {
        String answer = "";

        LocalDate date = LocalDate.of(2016, a, b);
        switch(date.getDayOfWeek()){
            case SUNDAY:
                answer = "SUN";break;
            case MONDAY:
                answer = "MON";break;
            case TUESDAY:
                answer = "TUE";break;
            case WEDNESDAY:
                answer = "WED";break;
            case THURSDAY:
                answer = "THU";break;
            case FRIDAY:
                answer = "FRI";break;
            case SATURDAY:
                answer = "SAT";break;
            default:
                answer = "";break;
        }

        return answer;
    }

    // Zeller's Congruence라는 알고리즘 사용법
    public String solution2(int a, int b) {
        String[] week = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] monthDay = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 각 월별 일 수
        int totalDays = 0;

        for (int i = 0; i < a - 1; i++) {
            totalDays += monthDay[i]; // 해당 월의 이전 월까지의 일수를 더함
        }

        totalDays += (b - 1); // 해당 월의 일수를 더함(1월 1일이 시작이므로 -1)

        return week[totalDays % 7];
    }
}
