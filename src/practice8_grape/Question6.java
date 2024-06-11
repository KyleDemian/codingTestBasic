package practice8_grape;

import java.io.*;
import java.util.*;

public class Question6 {

    // 이건 이해가 잘 안됌... 잘 많이 나오는 스타일이라고 함.

    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;
        HashMap<String, Integer> node = new HashMap<>();
        for(int i = 0; i < n; i++) node.put(subjects[i], i);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        int[] indegree = new int[n];
        for(String x : course){
            int a = node.get(x.split(" ")[0]);
            int b = node.get(x.split(" ")[1]);
            graph.get(b).add(a);
            indegree[a]++;
        }

        ArrayList<Integer> order = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // 차수 등록
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) queue.offer(i);
        }

        // 위상정렬 하는 부분
        while(!queue.isEmpty()){
            int pre = queue.poll();
            order.add(pre);
            for(int x : graph.get(pre)){
                indegree[x]--;
                if(indegree[x] == 0){
                    queue.offer(x);
                }
            }
        }
        String[] answer = new String[n];
        System.out.println(order);
        for(int i = 0; i < n; i++){
            answer[i] = subjects[order.get(i)];
        }
        return answer;
    }

    public static void main(String[] args){
        Question6 T = new Question6();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
        //System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
        //System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }
}
