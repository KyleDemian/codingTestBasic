# 콜롬버스 스터디 1주차

## 목차

- [Q1. 알고리즘/자료구조](#q1-알고리즘자료구조란)
- [Q2. 시간복잡도/공간복잡도/빅오 표기법](#q2-시간복잡도공간복잡도빅오-표기법-이란)
- [Q3. 자바 문자열 함수](#q3-자바-문자열-함수)

---

## Q1. 알고리즘/자료구조란?

알고리즘은 문제를 해결하기 위한 절차나 방법입니다. 프로그램 작성 시에 알고리즘에 따라 개발이 이루어지거나 문제를 해결하는 방법 중 하나입니다.

자료구조는 데이터를 효율적으로 저장하기 위한 구조입니다. Java의 Collection 예를 들면, Set, List, Map, Queue, Stack 등이 존재합니다.

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