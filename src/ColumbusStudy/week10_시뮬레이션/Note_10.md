파이어 볼 문제

해당 문제는 지금도 사실 답을 모르겠음.

계속 아웃오브 레인지가 뜨는데 해당 소스상으로는 문제가 없어보임

예제를 바꿔가면서 해도 문제가 안남

코드리뷰하면서 계산하는 부분에 > 0 보다 작았을떄 처리하는걸 넣으면 어떻겠냐고해서 해당 부분을 넣어도 답이 나오지가 않음..

java```
static void moveFireballs() {
    for (Fireball fb : fireballs) {
        map[fb.r][fb.c].remove(fb);
        fb.r = (fb.r + dr[fb.d]*fb.s - 1 + N) % N + 1;
        fb.c = (fb.c + dc[fb.d]*fb.s - 1 + N) % N + 1;
        if(fb.r > 0 )  fb.r += N +1;
    map[fb.r][fb.c].add(fb);
    }
}
```

그래서 이 문제는 다른 사람의 답안을 보고 풀었고,

그 차이점은 아직도 모르겠음..