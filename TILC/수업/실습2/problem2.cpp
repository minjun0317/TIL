#include <stdio.h>


void max(int a, int b)
{
    if(a > b) {
        printf("더 큰 값은 %d입니다.\n", a);
    } else {
        printf("더 큰 값은 %d입니다.\n", b);
    }
}

int main(void) {
    int a, b;
    printf("정수 2개를 입력하시오 : ");
    scanf("%d %d", &a, &b);
    max(a, b);
    return 0;

}
