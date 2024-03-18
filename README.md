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

// 여기에 설명을 추가하세요

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