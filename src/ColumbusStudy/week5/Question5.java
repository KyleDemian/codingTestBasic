package ColumbusStudy.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question5 {

    // https://www.acmicpc.net/problem/15721
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());    // a 명
        int t = Integer.parseInt(br.readLine());    // t 번째
        int n = Integer.parseInt(br.readLine());    // 뻔-0, 데기-1

        // 뻔 - 데기 - 뻔 - 데기 - 뻔 - 뻔 - 데기 - 데기                         1회차
        // 뻔 - 데기 - 뻔 - 데기 - 뻔 - 뻔 - 뻔 - 데기 - 데기 - 데기             2회차
        // 뻔 - 데기 - 뻔 - 데기 - 뻔 - 뻔 - 뻔 - 뻔 - 데기 - 데기 - 데기 - 데기 3회차
        // 0  -  1   - 2  -   3  - 4  - 5  - 6  -  7 -  8   -  9   -  10  -  11
        // 0     1     2      3    0    1    2     3    0      1      2      3 ( 사람은 0부터 시작해야함 )

        // 게임을 진행하면서 출력을 내는 구조
        // 뻔->데기->뻔->데기->뻔*n->데기*n
        int totalChant = 0;
        int bb = 0;
        int de = 0;

        boolean isDone = false;

        for (int i = 2; !isDone; i++) {
            for (int j = 0; j < 4; j++) {
                totalChant++;
                if (j % 2 == 0) bb++;
                if (j % 2 == 1) de++;
                if ((n == 0 && bb == t) || (n == 1 && de == t)) {
                    System.out.println((totalChant - 1) % a);
                    isDone = true;
                    break;
                }
            }
            if (!isDone) {
                for (int j = 0; j < 2 * i; j++) {
                    totalChant++;
                    if (j < i) bb++;
                    if (j >= i) de++;
                    if ((n == 0 && bb == t) || (n == 1 && de == t)) {
                        System.out.println((totalChant - 1) % a);
                        isDone = true;
                        break;
                    }
                }
            }
        }
    }
}

// 이 코드는 출입문(game chant)을 수행하는 사람들의 숫자(a), 누군가가 "뻔" 또는 "데기"를 특정 번째 부를 때의 위치를 찾는 프로그램입니다(t는 "뻔" 또는 "데기"가 특정 번 부를 때의 위치를 나타내고, n은 "뻔" 또는 "데기"를 나타냅니다).
//코드는 두 부분으로 나누어져 있습니다:
//첫번째 부분은 "뻔, 데기, 뻔, 데기"를 부르는 부분입니다 (내부의 첫번째 for 루프).
//두번째 부분은 나머지 "뻔, 뻔, ..., 데기, 데기"를 부르는 부분입니다 (내부의 두번째 for 루프).
//각 부분에서 zeroCount (뻔을 몇 번 부르는지를 세는 횟수)와 oneCount ("데기"를 몇 번 부르는지를 세는 횟수)를 계산합니다.
//이 두 횟수 중 하나가 입력 값 t와 같아지면 (예: 누군가가 "뻔" 또는 "데기"를 t번째 부르게 되면), 그 순간의 위치(totalChant - 1)를 출력한 후 isDone을 true로 설정하고 현재 루프를 종료합니다.
//"뻔" 또는 "데기"가 t 번 부르는 순간이 첫번째 부분에서 일어나지 않는다면(isDone이 여전히 false인 경우), 두번째 부분에서 계속 진행합니다.
//위체와 같은 로직이 두번째 부분에도 적용됩니다.
//이 두 부분이 모두 종료되면 (즉, 라운드에 해당하는 외부 for 루프의 각 반복이 끝나면), 다음 라운드로 넘어갑니다 (외부 for 루프의 반복이 계속 발생합니다). 이를 통해 각 라운드마다 "뻔, 데기, 뻔, 데기" 패턴이 반복되며, 그 다음에는 그 패턴의 "뻔"과 "데기"가 같은 횟수만큼 더 반복됩니다.
//추가로 함께 고려해야 할 사항은 totalChant 값을 a로 나누어 나머지를 취하는 것입니다. 이 작업은 총 인원 수(a)로 순환하여 계속 순환되는 위치 계산을 수행합니다. 이렇게 하면 출력값은 항상 0과 a - 1 사이의 값이 보장됩니다. 즉, 사람의 숫자로 순환하는 위치를 나타냅니다.


// 이 for문은 노래 반복 패턴의 각 '라운드'를 나타냅니다. 여기서 i는 라운드 번호를 의미하며, 매 라운드마다 이 값이 1씩 증가합니다.
//하나의 라운드는 "뻔, 데기, 뻔, 데기" 패턴을 가지고 시작하고, 이후에는 라운드 번호에 따라 "뻔"과 "데기"가 같은 숫자만큼 반복됩니다. isDone 변수는 특정 횟수(t) 동안 "뻔" 또는 "데기"를 부른 사용자를 찾았는지를 나타냅니다. 따라서, isDone이 true가 될 때까지 노래가 계속되고, isDone이 true가 되면 노래가 종료됩니다.
//각 라운드가 끝날 때마다, zeroCount와 oneCount는 초기화되지 않으므로, 그들은 "뻔"과 "데기"가 누적해서 몇 번 부르러졌는지를 계속 추적하게 됩니다.
//이렇게 for문을 사용함으로써, 언제 "뻔" 또는 "데기"가 특정 횟수만큼 부른 사용자를 찾을 수 있는지를 제어하게 되는 것입니다.