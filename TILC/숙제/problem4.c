#include <stdio.h>

int ganadi(int n)
{
    int i;
    if (n < 0)
        n = -n;

    printf("%d의 약수: ", n);

    for (i = 1; i <= n; i++)
    {
        if (n % i == 0)
            printf("%d ", i);
    }

    printf("\n");
}

int main(void)
{
    int n;

    printf("정수를 입력하세요: ");
    scanf("%d", &n);
    ganadi(n);

    return 0;
}
