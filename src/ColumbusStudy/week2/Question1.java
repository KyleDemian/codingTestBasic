package ColumbusStudy.week2;

import java.io.*;
import java.util.*;

public class Question1 {
    // https://www.acmicpc.net/problem/18258
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int last = 0;
        String[] arr = new String[n];
        for(int i=0; i < n ; i++){
            arr[i] = br.readLine();
        }

        //push X: 정수 X를 큐에 넣는 연산이다.
        //pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        //size: 큐에 들어있는 정수의 개수를 출력한다.
        //empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        //front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        //back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

        for(int i=0; i < n ; i++){
            StringTokenizer st = new StringTokenizer(arr[i]);
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    q.offer(last);
                    break;
                case "pop":
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(q.peek()).append("\n");
                    break;
                case "back":
                    if(q.isEmpty()) sb.append("-1\n");
                    else sb.append(last).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
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
