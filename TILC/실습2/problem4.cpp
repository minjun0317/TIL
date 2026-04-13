#include <stdio.h>

int add(int x, int y)
{
    return x + y;
}

int main()
{
    int x, y;
    printf("두 정수를 입력하시오 : ");
    scanf("%d %d", &x, &y);
    printf("두 정수의 합 %d입니다.\n", add(x, y));
    return 0;
}