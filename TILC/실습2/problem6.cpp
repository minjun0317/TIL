#include <stdio.h>

unsigned long long ganadi(int n)
{
    unsigned long long result = 1;
    for (int i = 1; i <= n; i++)
    {
        result *= i;
    }
    return result;
}

int main()
{
    int n;
    printf("알고 싶은 팩토리얼의 값은? ");
    scanf("%d", &n);

    unsigned long long value = ganadi(n);
    printf("%d!의 값은 %llu 입니다.\n", n, value);
    return 0;
}