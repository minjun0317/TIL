#include <stdio.h>

int ganadi(int n)
{
    int sum = 0;
    int i;

    for (i = 2; i <= n; i += 2) {
        sum += i;
    }

    return sum;
}

int main(void)
{
    int n;
    printf("정수를 입력 : ");
    scanf("%d", &n);
    printf("1부터 %d까지 짝수 합: %d\n", n, ganadi(n));

    return 0;
}