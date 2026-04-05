#include <stdio.h>

int main() {
    int h, m;
    printf("시간 입력 : ");
    if (scanf("%d", &h) != 1) 
    return 0;

    printf("분 입력 : ");
    if (scanf("%d", &m) != 1) 
    return 0;

    m -= 30;
    if (m < 0) {
        m += 60;
        h -= 1;
    }
    if (h < 0) {
        h += 24;
    }

    printf("%d시 %d분\n", h, m);
    return 0;
}