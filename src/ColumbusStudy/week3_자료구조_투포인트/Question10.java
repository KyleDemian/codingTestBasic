package ColumbusStudy.week3_자료구조_투포인트;

import java.io.*;
import java.util.*;

public class Question10 {

    // https://www.acmicpc.net/problem/19583
    // 복습 완료

    static int getTime(String str){
        int hour = Integer.parseInt(str.split(":")[0]);
        int minute = Integer.parseInt(str.split(":")[1]);
        return (hour * 60) + minute;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 시간 확인
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sTime = getTime(st.nextToken());
        int eTime = getTime(st.nextToken());
        int smTime = getTime(st.nextToken());

        // HashMap 의 경우 Key, Value // Set 은 중복 제거 ( 같은 이름을 제거해야함 필수! )
        HashSet<String> sHm = new HashSet<>();
        HashSet<String> eHm = new HashSet<>();

        String input;
        while((input = br.readLine()) != null && !input.equals("")){
            String[] str = input.split(" ");
            int userTime = getTime(str[0]);
            String userName = str[1];

            // 출석 찍은 사람들
            if(userTime <= sTime){
                sHm.add(userName);
            }

            // 퇴장 찍은 사람들
            if(eTime <= userTime  && userTime <= smTime){
                eHm.add(userName);
            }
        }

        int answer = 0;
        for(String students : sHm){
            if(eHm.contains(students)){
                answer++;
            }
        }
        System.out.print(answer);
    }
}



/*
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = reader.readLine().split(" ");
        LocalTime start = LocalTime.parse(temp[0]);
        LocalTime end = LocalTime.parse(temp[1]);
        LocalTime closing = LocalTime.parse(temp[2]);

        HashMap<String, Integer> hm = new HashMap<>();

        String input;
        while((input = reader.readLine()) != null && !input.equals("")) {
            String[] data = input.split(" ");
            LocalTime chatTime = LocalTime.parse(data[0]);
            String user = data[1];

            if (chatTime.compareTo(start) <= 0) {
                hm.put(user, hm.getOrDefault(user, 0)+1);
            }
            if (chatTime.compareTo(end) >= 0 && chatTime.compareTo(closing) <= 0) {
                hm.put(user, hm.getOrDefault(user, 0)+1);
            }
        }

        long result = hm.entrySet().stream().filter(entry -> entry.getValue() >= 2).count();

        System.out.println(result);
    }

 */