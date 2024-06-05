package ColumbusStudy.week2_스택_큐;

import java.io.*;
import java.util.*;

public class Question1 {
    // https://www.acmicpc.net/problem/18258
    // 복습 완 ( 2024 06 04 )
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    q.offer(n);
                    last = n;
                    break;
                case "pop":
                    if(!q.isEmpty()) sb.append(q.poll()).append("\n");
                    else sb.append("-1").append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "front":
                    if(!q.isEmpty()) sb.append(q.peek()).append("\n");
                    else sb.append("-1").append("\n");
                    break;
                case "back":
                    if(!q.isEmpty()) sb.append(last).append("\n");
                    else sb.append("-1").append("\n");
                    break;
            }
        }
        System.out.print(sb.toString());
    }

    /*
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = kb.nextInt();
        kb.nextLine();
        String[] arr = new String[n];
        for(int i=0; i < arr.length ; i++){
            arr[i] = kb.nextLine();
        }

        Queue<Integer> q = new LinkedList<>();
        int last = 0;

        // n 값만큼 돌려야함.
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(arr[i]);
            String cmd = st.nextToken();
            if(arr[i].contains("push")){
                last = Integer.parseInt(st.nextToken());
                q.offer(last);
            }else if(arr[i].equals("pop")){
                if(q.isEmpty()) sb.append("-1").append("\n");
                else sb.append(q.poll()).append("\n");
            }else if(arr[i].equals("size")){
                sb.append(q.size()).append("\n");
            }else if(arr[i].equals("empty")){
                if(q.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }else if(arr[i].equals("front")){
                if(q.isEmpty()) sb.append("-1").append("\n");
                else sb.append(q.peek()).append("\n");
            }else if(arr[i].equals("back")){
                if(q.isEmpty()) sb.append("-1").append("\n");
                else sb.append(last).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
    */

}
