package ColumbusStudy.week4_그리디;

public class Question9 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/72410

    public String solution(String new_id) {
        String answer = "";

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");

        // 3단계
        new_id = new_id.replaceAll("\\.{2,}", ".");

        // 4단계
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // 5단계
        // Null 일경우 str.equals("") 도 공백처리 이고, 이때는 false 를 반환
        // isEmpty()의 경우 NPE를 발생시킴.
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6단계
        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("^[.]|[.]$", "");
        }

        // 7단계 Index 의 경우 0부터 시작하기떄문에 length()-1
        while (new_id.length() < 3){
            new_id += new_id.charAt(new_id.length()-1);
        }

        answer = new_id;

        return answer;
    }

    public static void main(String[] args) {
        Question9 T = new Question9();
        System.out.print(T.solution("new_id..32wsdsdrwerw45435"));
    }
}
