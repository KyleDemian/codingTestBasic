# 파이어볼 문제

이 문제를 푸는 데 있어서는 아직도 답을 확실하게 모르겠습니다. 계속해서 `ArrayIndexOutOfBoundsException`이 발생하지만, 현재 코드상으로는 문제가 없어보입니다.

주어진 예제를 바꿔가며 시도해보았지만 여전히 오류가 발생합니다. 코드 리뷰를 진행하면서 계산에 있어서 `fb.r` 가 0보다 작았을 때의 처리를 추가하면 어떨지에 대한 의견이 있어서 해당 부분을 추가해봤지만, 여전히 답을 얻을 수 없었습니다.

static void moveFireballs() {
for (Fireball fb : fireballs) {
map[fb.r][fb.c].remove(fb);
fb.r = (fb.r + dr[fb.d]*fb.s - 1 + N) % N + 1;
fb.c = (fb.c + dc[fb.d]*fb.s - 1 + N) % N + 1;
if(fb.r > 0 )  fb.r += N +1;
map[fb.r][fb.c].add(fb);
}
}