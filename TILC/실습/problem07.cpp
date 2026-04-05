#include <stdio.h>

int main() {
    int year;
    printf("year = ");
    if (scanf("%d", &year) != 1) {
        return 1;
    }

    if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
        printf("윤년\n");
    } else {
        printf("윤년이 아닙니다\n");
    }

    return 0;
}