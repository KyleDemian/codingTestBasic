Week1
Day01

Question 1 ( Queue )
- 문제의 난이도 자체는 어렵지 않았음
다만 해당 문제의 가장 중요한 점은 시간복잡도를 ( 메모리 사용량 ) 어떻게 설정하는지에 따라서
문제의 풀이가 달라지는것으로 확인되었음.

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
int n = Integer.parseInt(br.readLine());
Queue<Integer> q = new LinkedList<>();
q.offer(br.readLine());

위와 같이 풀었을경우는 통과 되었지만,
Scanner kb = new Scanner(System.in);
으로 입력을 받고, I/O 를 System.out.print 로 한행마다 직접 작성시에는 시간초과로 문제가 해결되지 않았음.

Question 2 ( Stack )
- 문자 자체는 어렵지 않았고, Stack 의 구조만 알면 풀수 있는 문제 였음
다만, 문제를 풀때 예외 케이스를 무조건 생각하고 풀었어야 함, 처음 문제를 넘길떄 예외케이스를 생각 못하고 풀어서
')' 이것부터 드렁오면 스택 자체를 비운 상태로 해당 시스템을 끝내기 때문에, 하나의 처리를 더 진행 해 주었음.

Question 3
- 문제 스택자체를 기존 동일하게 가기때문에 문제 자체가 어렵지는 않았음.
기존의 인프런 문제에서도 괄호 문제가 있어서 해당 문제는 동일하게 풀 수 있었고,
다만 Double 형태로 구성을 해야만 했다.

Question 4
- 처음 기본 배열이 설정 되어있다고 생각하지 않았다고 문제를 접근 하다보니 어떻게 해결할 방법이 없었음.
인터넷 검색을 해보니 해당 배열은 처음에 만드는 배열이 아니고 주어진 값이였음.

또한 해당 배열에서 신규로 배열을 만들어서 ++++ -- 등등의 구조를 추가하는 방식으로 작성을 하였음.

Question 5 && Question 6
두개의 문제는 완전 동일 한 구조로 하나의 문제를 이해하면 문제를 쉽게 해결해 나갈수 있음.

스택의 자료구조를 통해서 2개의 구조를 만듦
왼쪽 스택은 시작 스택
출력스택은 오른쪽 스택 으로 하여
커서는 항상 맨 위쪽이라고 가정을하고 그 스택대로 움직이면 해당 문제는 쉽게 풀림.

Question 7
요세푸스 문제
해당 요세푸스 문제 자체를 이해하는게 가장 큰 문제였음.
하지만 일단 해당 문제의 요점은 원으로 둘러앉아있다고 가정을 하고
N 명의 사람이 일단 앉아있고,

K번 째 사람을 구하는것임 그러면 1 to N까지를 생각하고,
K 번째 사람을 구하면 됐음 그래서 I = 0 -> K번째까지 구하게 되면 3 6 2 7 5 1 4
순으로 K 번째씩 사람을 구하면 됏음

Question 8
문제 이해가 안됐음!