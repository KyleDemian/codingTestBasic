오답 노트

Q. 단절점과 단절선
해당 문제는 어떻게 접근을 해야하는지 아예 풀지못했습니다.

트리에서 간선이 없어질 경우
간선이 없어지는 경우는 모두 똑같다. 한 정점과 다른 한 정점의 연결이 끊어지기 때문에 당연히 트리는 2개의 그래프로 나눠질 수 밖에 없다.

정점이 없어지는 경우
이 또한 연결되어 있는 간선의 갯수로 변화를 파악할 수 있다. 해당 정점이 없어지게 되면 해당 간선의 갯수만큼의 그래프가 생기게 된다.
만약 리프노드인 경우는 간선이 1개이므로 없애도 1개의 트리 또는 그래프를 생기게 된다.

선이 2개인 정점을 없애는 경우, 2개의 트리 또는 그래프가 생기게 된다. 마찬가지로 3개인 경우에는, 3개의 트리 또는 그래프가 생기는 것을 알 수 있다.

설계
주어지는 간선의 데이터를 인접리스트 배열에 저장한다.
1번 쿼리가 주어지는 경우, 해당 정점의 간선의 갯수로 그래프의 수를 파악한다.
해당 정점의 간선의 갯수가 2개 이상인 경우, "yes"를 출력한다.
아닌  경우, "no"를 출력한다.
2번 쿼리가 주어지는 경우, 무조건 2개의 그래프로 나눠지기 때문에 "yes"를 출력한다.

```java
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		List<Integer>[] list = new ArrayList[n+1];
		for(int i=1; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		StringBuilder sb = new StringBuilder();
		int q = Integer.parseInt(br.readLine());
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			if(op==2) {
				sb.append("yes\n");
			}else {
				int idx = Integer.parseInt(st.nextToken());
				if(list[idx].size() >=2) sb.append("yes\n");
				else sb.append("no\n");
			}
		}
		System.out.println(sb.toString());
	}
}
```

형식으로 풀이를 확인 하였고, 아직 문제는 잘 이해가 되지 않음... ㅠ