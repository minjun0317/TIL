#include <stdio.h>

int prime(int n)
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

int main()
{
    int n;
    printf("정수를 입력해 : ");
    scanf("%d", &n);

    if (prime(n)) {
        printf("%d는 소수입니다.\n", n);
    } else {
        printf("%d는 소수가 아닙니다.\n", n);
    }

    return 0;

}