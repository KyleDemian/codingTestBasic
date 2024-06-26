package ColumbusStudy.week12_기출풀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Question8 {

    // https://www.acmicpc.net/problem/13022
    // 이해는 잘 안됌..
    // https://moons-memo.tistory.com/category/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/%EC%BD%94%ED%85%8C%EC%97%90%20%ED%95%84%EC%9A%94%ED%95%9C%20%EC%A7%80%EC%8B%9D%EB%A7%8C
    static int count[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        int len = str.length();

        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('w', 0);
        hm.put('o', 1);
        hm.put('l', 2);
        hm.put('f', 3);

        if(len % 4 != 0 || str.charAt(0) != 'w'){
            System.out.print(0);
        } else {
            // 0, 1, 2, 3 매칭
            count = new int[4];
            boolean flag = true;

            // 첫번째 글자를 넣어줌
            count[hm.get(str.charAt(0))] = 1;

            // 첫글자를 시작했음
            for(int i = 1; i < len; i++){
                int preWord = hm.get(str.charAt(i-1));
                int curWord = hm.get(str.charAt(i));
                int diff = curWord - preWord;

                if(diff == -3){
                    if(check()){
                        count = new int[4];
                        count[0] = 1;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    if (diff == 1 || diff == 0) {
                        count[curWord]++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (!check()) {
                flag = false;
            }

            if(flag) System.out.println(1);
            else System.out.println(0);
        }
    }

    static boolean check(){
        if(count[0] == count[1] && count[1] == count[2] && count[2] == count[3]) return true;
        else return false;
    }
}
