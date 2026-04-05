#include <stdio.h>

int main() {
    int num;
    printf("공의 위치 : ");
    scanf("%d", &num);
    if (num <= 40 && num >= 30 || num <=70 && num >= 60) {
        printf("Win\n");
    }
    else {
        printf("Lose\n");
    }
    return 0;
}