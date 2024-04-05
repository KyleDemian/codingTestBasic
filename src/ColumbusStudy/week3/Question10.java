package ColumbusStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Question10 {

    // https://www.acmicpc.net/problem/19583

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        String[] start = temp[0].split(":");
        String[] end = temp[1].split(":");
        String[] closing = temp[2].split(":");

        LocalTime startTime = LocalTime.of(Integer.parseInt(start[0]) , Integer.parseInt(start[1]));
        LocalTime endTime = LocalTime.of(Integer.parseInt(end[0]) , Integer.parseInt(end[1]));
        LocalTime closingTime = LocalTime.of(Integer.parseInt(closing[0]) , Integer.parseInt(closing[1]));

        // 채팅 시작전 참석 목록
        HashSet<String> attendance = new HashSet<>();
        // 수업종료 후 채팅 목록
        HashSet<String> validChat = new HashSet<>();

        String input;
        while ((input = br.readLine()) != null && !input.equals("")) {
            String[] arr = input.split(" ");
            LocalTime chatTime = LocalTime.of(Integer.parseInt(arr[0].split(":")[0]) , Integer.parseInt(arr[0].split(":")[1]));
            String user = arr[1];
            // isBefore isAfter 의 경우 현재시간이 포함 안되고, Boolean 값을 반환하지만
            // LocalDateTime, LocalDate etc 등...
            // compareTo 를 사용시, 두 날짜의 객체가 시간이 앞서면 음수, 같으면 0, 뒤의날이면 양수를 반환 함.
            if (chatTime.compareTo(startTime) <= 0) {
                attendance.add(user);
            }

            if (chatTime.compareTo(endTime) >= 0 && chatTime.compareTo(closingTime) <= 0) {
                validChat.add(user);
            }
        }

        int result = 0;
        for (String user : attendance) {
            if (validChat.contains(user)) {
                result++;
            }
        }

        System.out.print(result);
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