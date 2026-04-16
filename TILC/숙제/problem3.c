#include <stdio.h>

int ganadi(int n)
{
    if (n <= 1) {
        return 0;
    }
    for (int i = 2; i <= n / 2; i++) {
        if (n % i == 0) {
            return 0;
        }
    }
    return 1;
}

int main(void)
{
    int n;
    printf("정수를 입력 : ");
    scanf("%d", &n);
    printf("정수 n이 소수면 1, 아니면 0 : %d\n", ganadi(n));
    return 0;
}