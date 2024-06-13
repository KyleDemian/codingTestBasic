package ColumbusStudy.week11_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Question11 {

    // https://www.acmicpc.net/problem/20436
    // 틀린 이유 : 키보드 생성시 자음 과 모음

    static HashMap<Character, Point> left = new HashMap<>();
    static HashMap<Character, Point> right = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makeKeyBoard();

        StringTokenizer st = new StringTokenizer(br.readLine());
        Point lF = left.get(st.nextToken().charAt(0));
        Point rF = right.get(st.nextToken().charAt(0));

        String str = br.readLine();
        // 클릭 및 한칸씩 움직일때마다 +1 초씩
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if(left.containsKey(str.charAt(i))){
                Point lD = left.get(str.charAt(i));
                answer += Math.abs(lF.x - lD.x) + Math.abs(lF.y - lD.y) + 1;
                lF = lD;
            } else if ( right.containsKey(str.charAt(i))){
                Point rD = right.get(str.charAt(i));
                answer += Math.abs(rF.x - rD.x) + Math.abs(rF.y - rD.y) + 1;
                rF = rD;
            }
        }

        System.out.println(answer);

    }

    // 자음 모음
    static void makeKeyBoard(){
        // 1행
        left.put('q', new Point(0,0));
        left.put('w', new Point(0,1));
        left.put('e', new Point(0,2));
        left.put('r', new Point(0,3));
        left.put('t', new Point(0,4));
        right.put('y', new Point(0,5));
        right.put('u', new Point(0,6));
        right.put('i', new Point(0,7));
        right.put('o', new Point(0,8));
        right.put('p', new Point(0,9));

        // 2행
        left.put('a', new Point(1,0));
        left.put('s', new Point(1,1));
        left.put('d', new Point(1,2));
        left.put('f', new Point(1,3));
        left.put('g', new Point(1,4));
        right.put('h', new Point(1,5));
        right.put('j', new Point(1,6));
        right.put('k', new Point(1,7));
        right.put('l', new Point(1,8));

        // 3행
        left.put('z', new Point(2,0));
        left.put('x', new Point(2,1));
        left.put('c', new Point(2,2));
        left.put('v', new Point(2,3));
        right.put('b', new Point(2,4));
        right.put('n', new Point(2,5));
        right.put('m', new Point(2,6));
    }

    // 좌표 값
    static class Point {
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
