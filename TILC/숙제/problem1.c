#include <stdio.h>

int main(void) {
    int a,b,c;
    printf("세 정수 입력 : ");
    if (scanf("%d %d %d", &a, &b, &c))
    {
        if (a > b && a > c) {
            printf("가장 큰 수 %d\n", a);
        }
        else if (b > a && b > c) {
            printf("가장 큰 수 %d\n", b);
        }
        else {
            printf("가장 큰 수 %d\n", c);
        }
    }
    return 0;
}