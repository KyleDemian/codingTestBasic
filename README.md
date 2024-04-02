# 콜롬버스 스터디 1~3 주차

## 목차

- [Q1. 알고리즘/자료구조](#q1-알고리즘자료구조란)
- [Q2. 시간복잡도/공간복잡도/빅오 표기법](#q2-시간복잡도공간복잡도빅오-표기법-이란)
- [Q3. 자바 문자열 함수](#q3-자바-문자열-함수)
- [Q4. 스택과 큐를 구현하시오.](#q4-스택과-큐를-구현하시오)
- [Q5. LinkedList를 구현하시오.](#q5-LinkedList를-구현하시오)
- [Q6. Hash Table](#q6-Hash-Table)
- [Q7. Deque](#q7-Deque)
- [Q8. 투포인터](#q8-투포인터)

---

## Q1. 알고리즘/자료구조란?

알고리즘은 문제를 해결하기 위한 절차나 방법입니다. 프로그램 작성 시에 알고리즘에 따라 개발이 이루어지거나 문제를 해결하는 방법 중 하나입니다.

자료구조는 데이터를 효율적으로 저장하기 위한 구조입니다. Java의 Collection 예를 들면, Set, List, Map, Queue, Stack 등이 존재합니다. 또한 그런 구조들을 선형구조와 비선형구조로도 나눌수 있는데, 비선형 구조는 트리 그래프등이 비선형이고 나머지는 선형 구조입니다.

---

## Q2. 시간복잡도/공간복잡도/빅오 표기법 이란?

### 시간복잡도

시간복잡도는 알고리즘이 문제를 해결하는 데 얼마나 많은 시간(연산)이 필요한지 측정합니다. 시간 복잡도는 입력값의 크기에 따라 어떻게 변하는지를 나타내며, 보통 Big-O 표기법(Big-O notation)을 사용하여 표현합니다. 예를 들어 O(n)는 입력이 n배 될 때 실행 시간도 n배 된다는 것을 의미합니다.

### 공간복잡도

공간복잡도는 알고리즘이 문제를 해결하는 데 얼마나 많은 메모리(공간)를 필요로하는지 측정합니다. 공간 복잡도 역시 입력값의 크기에 따라 어떻게 변하는지를 나타내며, Big-O 표기법을 사용하여 표현합니다. 예를 들어, O(n)은 입력 크기에 비례하여 메모리 사용량이 증가한다는 것을 의미합니다.

### 빅오 표기법 (Big-O notation)

빅오 표기법은 알고리즘의 시간 복잡도와 공간 복잡도를 수학적으로 표현하는 방법입니다. 가장 최악의 경우를 나타내므로, 알고리즘의 효율성을 비교할 때 유용합니다. Big-O 표기법은 아래와 같이 다양한 형태가 있습니다:

- **O(1)**: 항상 동일한 시간이 걸리는, 즉 입력 크기에 상관 없이 시간이 일정한 경우를 의미합니다.

- **O(n)**: 입력 크기에 비례하여 시간이 증가하는 경우를 의미합니다.

- **O(n^2)**: 입력 크기의 제곱에 비례하여 시간이 증가하는 경우를 의미합니다.

- **O(log n)**: 입력 크기의 로그에 비례하여 시간이 증가하는 경우를 의미합니다.

- O(1) < O(lon N) < O(N) < O(N log N) < O(N^2) < O(2^N) < O(N!)
---

## Q3. 자바 문자열 함수
#java 
#String a = "Hello World"; 
#String b = "hello World"; 
#String c = "aaa,bbb,ddd";
#char target = 'e';

1. **문자열 인덱싱 / 슬라이싱**
    - 인덱싱 -> `a.charAt(7)` -> 'W'
    - 슬라이싱 -> `a.substring(0, 5)` -> 'Hello'

2. **특정 문자가 있는지 확인**
    ```java
    for(int i = 0; i < a.length(); i++){
        if(a.charAt(i) == target) 
            return "YES";
    }
    ```

3. **문자열이 같은지 비교**
    ```java
    if(a.equals(b)) return false;
    if(a == b) return false;
    if(a == "Hello World") return true;
    // 단, new String("Hello World") 의 경우 메모리에 새로운 위치에 저장되기때문에 주의
    "Hello World".equals(new String("Hello World")) // true
    "Hello World" == new String("Hello World") // false
    ```

4. **문자열 길이 반환** -> `int cnt = a.length()`

5. **특정 문자의 인덱스 값 찾기** -> `int index = a.indexOf('e');` // 1

6. **문자열을 구분자 기준으로 나누고 합치기**
    ```java
    String[] arr = c.trim().split(",");  // , 기준으로 나누고 배열에 담기
    a.concat(b); // a + b;
    StringBuilder sb = new StringBuilder();
    sb.append(a);
    sb.append(b);
    ```

7. **문자열 대소문자 변환**
    - `a.toUpperCase();`
    - `b.toLowerCase();`
    - `Character.isAlphabetic(a.charAt(0));` -> 문자열인지 확인

8. **기존 값을 다른 값으로 치환**
    ```java
    String val = "12345";
    int value = 12345;

    int a = Integer.parseInt(val);
    String b = String.valueOf(value);

    String z = val.replace("1","a");
    String x = val.replaceAll("1","bb");
    ```

9. **양쪽 끝에서 특정 문자(혹은 공백) 제거** -> `a.trim()`

10. **아스키 코드로 변환 혹은 대소 비교**
    - 숫자 -> char num = 48 ~ 59 (0 ~ 9)
    - 소문자 -> char alphaLower = 97 ~ 122 (a to z)
    - 대문자 -> char alphaUpper = 65 ~ 90 (A to Z)

---
11. **제곱(근) 연산시**
    - Math.pow(n,m) n 을 m 번을 제곱한 값을 반환
    - Math.sqrt(n) n의 제곱근을 반환 함.

12. 최대 공약수(GCD) / 최소 공배수(LCM) 구하는 
    ```java
    static int gcd(int a, int b) {
        if (b==0)
            return a;
        return gcd(b, a%b);
    }

    static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }

    public static void main(String[] args) {
        int a = 15, b = 20;
        System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));
        System.out.println("LCM of " + a +" and " + b + " is " + lcm(a, b));
    }
    ```
    
13. 소수 판별법 ( 에라토스테네스의 체와 제곱근을 이용한 소수 판별법)
```java
    // 애라토스테네스의 체
    public static void main(String[] args) {
        int maxNum = 100;
        boolean[] isComposite = new boolean[maxNum + 1];
    
        for (int i = 2; i*i < maxNum; i++) {
            if (!isComposite[i]) {
                for (int j = i; i*j <= maxNum; j++) {
                    isComposite[i*j] = true;
                }
            }
        }
    
        for (int i = 2; i <= maxNum ; i++ ) {
            if (!isComposite[i]) {
                System.out.println (i);
            }
        }
    }

    // 제곱근 
    static boolean isPrime(int num) {
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        int sqrt = (int)Math.sqrt(num);
        for(int i = 3; i <= sqrt; i+=2) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
```
14. 나머지 몫 구하기
```java
   int quotient = number / divisor;  // 몫 구하기
   int remainder = number % divisor; // 나머지 구하기
```
15. 순열, 조합
?????

16. 2진수, 8진수, 16진수 변환
```java
String binary = Integer.toBinaryString(num);    // 2 진수
String octal = Integer.toOctalString(num);      // 8 진수
String hexadecimal = Integer.toHexString(num);  // 16 진수
```
17. 소인수 분해
```java
public static void primeFactors(int number) {
        // Print the number of 2s that divide number
        while (number % 2 == 0) {
            System.out.print(2 + " ");
            number /= 2;
        }

        // n must be odd at this point, thus skip the even numbers and iterate only for odd
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            // While i divides n, print i and divide n
            while (number % i == 0) {
                System.out.print(i + " ");
                number /= i;
            }
        }

        // This condition is to handle the case when number is a prime number greater than 2
        if (number > 2)
            System.out.print(number);
    }
```

---

## Q4. 스택과 큐를 구현하시오

1. Stack - Fist In Fist Out
```java
    import java.util.LinkedList;
    import java.util.Queue;
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        
        // 예상 출력 값 1
        q.poll();
        
        // false
        q.isEmpty();
        
        // 2
        q.size();
        
        // false
        q.contains(4);
    }

```

2. Queue - Last In First Out
```java
    import java.util.*;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        // 3
        stack.pop();
        
        // false
        stack.isEmpty();
        
        // 2
        stack.size();
        
        // true
        stack.contains(2);
        
        // 1
        stack.get(0);
    }
```

---

---

## Q5. LinkedList를 구현하시오

```java
    public class Node {
        int data;
        Node next;
    
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public class LinkedList {
        Node head;
    
        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = newNode;
            }
        }
    
        public void print() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            LinkedList list = new LinkedList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.print();  // 출력: 1 2 3
        }
    }
```
---

## Q6. Hash Table
- 해쉬 테이블은 키-값 으로 이루어지는 자료 구조이며, 순서가 없음.
만약 해당 해쉬 테이블을 정렬하고 싶으면, TreeMap 구조로 변경하여 정렬 할 수 있음.

또한, 해당 해쉬테이블의 경우 시간복잡도가 O(1) 이기때문에 빠른 검색이 가능함.
또한 Null을 허용 하지 않고, Thread-safe 한 구조라고 할 수 있음

그리고 사이즈도 가변으로 설정 할수 있기 때문에 메모리 효율도 좋다고 함.

## Q7. Deque
데큐는 큐 구조라고 생각하면 되고, 데큐어레이, 링크드 리스트등으로 구현 할 수 있음.
그리고 이걸 쓰는 이유는 list 보다 속도가 빠르고, Thread-safe 하기때문에 사용 할 수 있음

그리고 해당 구조는 일반 큐처럼 데이터를 넣고 뺼수 있지만 아래 처럼 사용 가능
```java
import java.util.Deque;
import java.util.LinkedList;

Deque<Integer> deque = new LinkedList<>();
// 마지막에 추가
deque.addLast(1);
deque.offerLast(2); // 위와 같은 작업
// 처음에 추가
deque.addFirst(0);
deque.offerFirst(-1); // 위와 같은 작업
// 마지막 요소를 제거하고 반환
int lastElement = deque.removeLast();
int lastElement = deque.pollLast(); // 위와 같은 작업, 하지만 데크가 비어 있을 경우 null 반환
// 시작 부분의 요소를 제거하고 반환:
int firstElement = deque.removeFirst();
int firstElement = deque.pollFirst(); // 위와 같은 작업, 하지만 데크가 비어 있을 경우 null 반환
// 마지막 요소를 반환하되 제거하지 않음:
int lastElement = deque.getLast();
int lastElement = deque.peekLast(); // 위와 같은 작업, 하지만 데크가 비어 있을 경우 null 반환
// 시작 부분의 요소를 반환하되 제거하지 않음:
int firstElement = deque.getFirst();
int firstElement = deque.peekFirst(); // 위와 같은 작업, 하지만 데크가 비어 있을 경우 null 반환
// deque 빈요소 반환
deque.clear();
```
등으로 사용 가능함.

물론, add 등으로 요소를 추가할 수 있지만, 정상적으로 들어가지 않았을경우, Exception을 발생 시킴

## Q8. 투포인터 
- 해당 알고리즘은 리스트(배열) 등에서 해당 위치를 잡고, Start(lt) , End(rt) 조건을 잡고 움직이면서 사용하는 대표적인 알고리즘
예를 들어서 아나그램코드를 작성할때

abcdeffacbab
abc

```java
public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        // 사전 세팅
        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
        }
        int L = b.length() - 1;
        for (int i = 0; i < L; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        // 투포인트 알고리즘, 슬라이딩 윈도우, 아나그램 알고리즘 equals
        int lt = 0;
        for (int rt = L; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
            if (am.equals(bm)) {
                answer++;
            }
            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if (am.get(a.charAt(lt)) == 0) {
                am.remove(a.charAt(lt));
            }
            lt++;
        }


        return answer;
    }
```

라고 코드가 작성되어있으면 해당 문제는 입력 받은값에서 abc 만큼 슬라이딩 하면서 잡는 알고리즘임.