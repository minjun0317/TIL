#include <stdio.h>

int ganadi(int n)
{
    if (n > 1) {
        ganadi(n / 2);
    }
    printf("%d", n % 2);
}

int main()
{
    int num;
    printf("정수입력 : ");
    scanf("%d", &num);
    ganadi(num);
    printf("\n");
    return 0;
}