package ColumbusStudy.week11_기출풀이;

import java.util.*;
import java.io.*;
public class Question13 {

    // https://www.acmicpc.net/problem/19583

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = getTime(st.nextToken());
        int end = getTime(st.nextToken());
        int sEnd = getTime(st.nextToken());

        HashSet<String> first = new HashSet<>();
        HashSet<String> second = new HashSet<>();

        String input;
        while((input = br.readLine()) != null && !input.isEmpty()){
            String[] arr = input.split(" ");
            int time = getTime(arr[0]);
            String name = arr[1];

            if(time <= start){
                first.add(name);
            }

            if(end <= time && time <= sEnd){
                second.add(name);
            }
        }

        int cnt = 0;
        for(String s : first){
            if(second.contains(s)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static int getTime(String str){
        int hour = Integer.parseInt(str.split(":")[0]);
        int minute = Integer.parseInt(str.split(":")[1]);
        return (hour * 60) + minute;
    }
}
