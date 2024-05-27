package ColumbusStudy.week4_그리디;

import java.util.*;

public class Question4 {

    // https://www.acmicpc.net/problem/20115

    // 욕나오는 이유...
    // 문제의 중간 : 임의의 서로 다른 두 에너지 드링크를 고른다.
    // 문제의 마지막 : 합쳐진 에너지 드링크의 양을 최대로 하려 한다
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = kb.nextInt();
        }

        Arrays.sort(arr,Collections.reverseOrder());

        // a의 양을 a + (b / 2)로 만들고, b를 버리기
        // 추출된 값을 기준으로 반씩 버리고 담기
        // 틀린 이유 더블의 경우 캐스팅 할때 2 -> 2.0 으로 던져야지만 정상적으로 캐스팅 됌
        double a = arr[0];
        for(int i = 1; i < arr.length ; i++){
            a += (arr[i]/2.0);
        }

        System.out.print(a);
        System.out.printf("%.4f", a);
    }
}

/*
        // 임의의 값을 추출
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while(set.size() < (n+1)){
            set.add(((int)Math.random() * n)+1);
        }
        List<Integer> list = new ArrayList<>(set);

        // 첫번째 선택된 값은 고정
        double a = list.get(0);
* */
